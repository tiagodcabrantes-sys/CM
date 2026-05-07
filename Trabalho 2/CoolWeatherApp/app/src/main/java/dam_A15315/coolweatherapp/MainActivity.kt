package dam_A15315.coolweatherapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.ImageView
import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import dam_A15315.coolweatherapp.databinding.ActivityMainBinding
import android.view.View

class MainActivity : AppCompatActivity() {
    var day = true
    private val LOCATION_PERMISSION_REQUEST_CODE = 1001

    lateinit var viewModel: WeatherViewModel
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        when (resources.configuration.orientation) {
            android.content.res.Configuration.ORIENTATION_PORTRAIT -> {
                if (day) {
                    setTheme(R.style.Theme_Day)
                } else {
                    setTheme(R.style.Theme_Night)
                }
            }
            android.content.res.Configuration.ORIENTATION_LANDSCAPE -> {
                if (day) {
                    setTheme(R.style.Theme_Day_Land)
                } else {
                    setTheme(R.style.Theme_Night_Land)
                }
            }
        }
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[WeatherViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        viewModel.weatherData.observe(this) { weather ->
            updateUI(weather)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.container)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val button = findViewById<Button>(R.id.buttonUpdate)

        button.setOnClickListener {

            val latText = findViewById<EditText>(R.id.editLatitude).text.toString()
            val longText = findViewById<EditText>(R.id.editLongitude).text.toString()

            if (latText.isEmpty() || longText.isEmpty()) return@setOnClickListener

            val lat = latText.toFloatOrNull()
            val long = longText.toFloatOrNull()

            if (lat == null || long == null) return@setOnClickListener

            viewModel.fetchWeatherData(lat, long)
        }

        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_PERMISSION_REQUEST_CODE
            )
        } else {
            getLocationAndWeather()
        }
    }

    private fun windDirectionToText(degrees: Int): String {
        return when (degrees) {
            in 0..22, in 338..360 -> "N"
            in 23..67 -> "NE"
            in 68..112 -> "E"
            in 113..157 -> "SE"
            in 158..202 -> "S"
            in 203..247 -> "SW"
            in 248..292 -> "W"
            else -> "NW"
        }
    }
    private fun updateUI(request: WeatherData) {
        runOnUiThread {

            val temperature = findViewById<TextView>(R.id.textTemperature)
            val windSpeed = findViewById<TextView>(R.id.textWindSpeed)
            val windDirection = findViewById<TextView>(R.id.textWindDirection)
            val time = findViewById<TextView>(R.id.textTime)
            val pressure = findViewById<TextView>(R.id.textPressure)
            val weatherImage = findViewById<ImageView>(R.id.imageWeather)
            val latView = findViewById<TextView>(R.id.textLatitude)
            val longView = findViewById<TextView>(R.id.textLongitude)
            val editLatitude = findViewById<EditText>(R.id.editLatitude)
            val editLongitude = findViewById<EditText>(R.id.editLongitude)

            latView.text = "%.2f".format(request.latitude.toFloat())
            longView.text = "%.2f".format(request.longitude.toFloat())

            temperature.text = "%.1f°C".format(request.current_weather.temperature)
            windSpeed.text = "%.1f km/h".format(request.current_weather.windspeed)
            pressure.text = "%.1f hPa".format(request.hourly.pressure_msl[12])

            windDirection.text = windDirectionToText(request.current_weather.winddirection)
            time.text = request.current_weather.time.substringAfter("T")

            editLatitude.setText("%.2f".format(request.latitude.toFloat()))
            editLongitude.setText("%.2f".format(request.longitude.toFloat()))

            val currentTime = request.current_weather.time
            val sunrise = request.daily.sunrise[0]
            val sunset = request.daily.sunset[0]

            day = currentTime >= sunrise && currentTime <= sunset

            val container = findViewById<View>(R.id.container)

            val isLandscape =
                resources.configuration.orientation == android.content.res.Configuration.ORIENTATION_LANDSCAPE

            if (day) {
                if (isLandscape) {
                    container.setBackgroundResource(R.drawable.weather_background_land)
                } else {
                    container.setBackgroundResource(R.drawable.weather_background)
                }
            } else {
                if (isLandscape) {
                    container.setBackgroundResource(R.drawable.night_land)
                } else {
                    container.setBackgroundResource(R.drawable.night_bg)
                }
            }

            val baseImage = getWeatherImageFromXml(request.current_weather.weathercode)

            val imageName = if (
                request.current_weather.weathercode == 0 ||
                request.current_weather.weathercode == 1 ||
                request.current_weather.weathercode == 2
            ) {
                if (day) baseImage + "day" else baseImage + "night"
            } else {
                baseImage
            }

            val resID = resources.getIdentifier(imageName, "drawable", packageName)
            weatherImage.setImageResource(resID)
        }
    }
    private fun getLocationAndWeather() {
        val locationManager = getSystemService(LOCATION_SERVICE) as LocationManager

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }

        val location: Location? = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)

        if (location != null) {
            val lat = location.latitude.toFloat()
            val long = location.longitude.toFloat()

            findViewById<EditText>(R.id.editLatitude).setText("%.2f".format(lat))
            findViewById<EditText>(R.id.editLongitude).setText("%.2f".format(long))

            viewModel.fetchWeatherData(lat, long)
        }
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLocationAndWeather()
            }
        }
    }
    private fun getWeatherImageFromXml(code: Int): String {
        val codes = resources.getIntArray(R.array.weather_codes)
        val images = resources.getStringArray(R.array.weather_images)

        val index = codes.indexOf(code)

        return if (index != -1) {
            images[index]
        } else {
            "fog"
        }
    }
}