package com.example.helloworldoptional

import android.os.Bundle
import android.os.Build
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)
        var info = ""
        info += "Manufacturer: " + Build.MANUFACTURER + "\n"
        info += "Brand: " + Build.BRAND + "\n"
        info += "Model: " + Build.MODEL + "\n"
        info += "Type: " + Build.TYPE + "\n"
        info += "User: " + Build.USER + "\n"
        info += "Base: " + Build.VERSION.BASE_OS + "\n"
        info += "Incremental: " + Build.VERSION.INCREMENTAL + "\n"
        info += "SDK: " + Build.VERSION.SDK_INT + "\n"
        info += "Version Code: " + Build.VERSION.SDK_INT + "\n"
        info += "Display: " + Build.DISPLAY + "\n"
        textView.text = info

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}