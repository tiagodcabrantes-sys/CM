package com.example.pokemongallery

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.pokemongallery.adapter.PokemonAdapter
import com.example.pokemongallery.ui.main.MainViewModel
import android.content.Intent
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.example.pokemongallery.data.model.PokemonUiModel
import android.widget.Button
import android.widget.TextView
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapter: PokemonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerPokemon = findViewById<RecyclerView>(R.id.recyclerPokemon)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val swipeRefresh = findViewById<SwipeRefreshLayout>(R.id.swipeRefresh)
        val favoritesContainer = findViewById<HorizontalScrollView>(R.id.favoritesContainer)
        val favoritesLayout = findViewById<LinearLayout>(R.id.favoritesLayout)
        val errorLayout = findViewById<LinearLayout>(R.id.errorLayout)
        val textError = findViewById<TextView>(R.id.textError)
        val buttonRetry = findViewById<Button>(R.id.buttonRetry)
        val searchEditText = findViewById<EditText>(R.id.searchEditText)
        val textCounter = findViewById<TextView>(R.id.textCounter)
        val buttonFire = findViewById<Button>(R.id.buttonFire)
        val buttonWater = findViewById<Button>(R.id.buttonWater)
        val buttonGrass = findViewById<Button>(R.id.buttonGrass)
        val buttonElectric = findViewById<Button>(R.id.buttonElectric)
        val buttonSortAZ = findViewById<Button>(R.id.buttonSortAZ)
        val buttonSortZA = findViewById<Button>(R.id.buttonSortZA)
        val buttonSortId = findViewById<Button>(R.id.buttonSortId)
        val buttonNormal = findViewById<Button>(R.id.buttonNormal)
        val buttonBug = findViewById<Button>(R.id.buttonBug)
        val buttonPoison = findViewById<Button>(R.id.buttonPoison)
        val buttonFlying = findViewById<Button>(R.id.buttonFlying)
        val buttonGround = findViewById<Button>(R.id.buttonGround)
        val buttonPsychic = findViewById<Button>(R.id.buttonPsychic)
        val emptyText = findViewById<TextView>(R.id.emptyText)
        val buttonHomeTab = findViewById<Button>(R.id.buttonHomeTab)
        val buttonFavoritesTab = findViewById<Button>(R.id.buttonFavoritesTab)

        buttonHomeTab.setOnClickListener {
            viewModel.showHome()
        }

        buttonFavoritesTab.setOnClickListener {
            viewModel.showFavoritesScreen()
        }

        buttonNormal.setOnClickListener {
            viewModel.filterByType("normal")
        }

        buttonBug.setOnClickListener {
            viewModel.filterByType("bug")
        }

        buttonPoison.setOnClickListener {
            viewModel.filterByType("poison")
        }

        buttonFlying.setOnClickListener {
            viewModel.filterByType("flying")
        }

        buttonGround.setOnClickListener {
            viewModel.filterByType("ground")
        }

        buttonPsychic.setOnClickListener {
            viewModel.filterByType("psychic")
        }

        buttonSortAZ.setOnClickListener {
            viewModel.sortByNameAsc()
        }

        buttonSortZA.setOnClickListener {
            viewModel.sortByNameDesc()
        }

        buttonSortId.setOnClickListener {
            viewModel.sortById()
        }


        buttonFire.setOnClickListener {
            viewModel.filterByType("fire")
        }

        buttonWater.setOnClickListener {
            viewModel.filterByType("water")
        }

        buttonGrass.setOnClickListener {
            viewModel.filterByType("grass")
        }

        buttonElectric.setOnClickListener {
            viewModel.filterByType("electric")
        }


        searchEditText.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.searchPokemon(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        adapter = PokemonAdapter(
            pokemonList = emptyList(),
            onItemClick = { pokemon ->

                val intent = Intent(this, PokemonDetailsActivity::class.java)

                intent.putExtra("name", pokemon.name)
                intent.putExtra("image", pokemon.imageUrl)
                intent.putExtra("height", pokemon.height)
                intent.putExtra("weight", pokemon.weight)
                intent.putExtra("types", pokemon.types.joinToString(", "))
                intent.putExtra("isFavorite", pokemon.isFavorite)
                intent.putExtra("hp", pokemon.hp)
                intent.putExtra("attack", pokemon.attack)
                intent.putExtra("defense", pokemon.defense)
                intent.putExtra("speed", pokemon.speed)

                startActivity(intent)
            },
            onFavoriteClick = { pokemon ->
                viewModel.toggleFavorite(pokemon, this)
            }
        )
        val columns = if (
            resources.configuration.orientation ==
            android.content.res.Configuration.ORIENTATION_LANDSCAPE
        ) {
            4
        } else {
            2
        }

        recyclerPokemon.layoutManager = GridLayoutManager(this, columns)
        recyclerPokemon.adapter = adapter

        viewModel.pokemonList.observe(this) { pokemon ->
            adapter.updateList(pokemon)
            textCounter.text = "Pokémon loaded: ${pokemon.size}"

            emptyText.visibility = if (pokemon.isEmpty()) View.VISIBLE else View.GONE
            recyclerPokemon.visibility = if (pokemon.isEmpty()) View.GONE else View.VISIBLE
        }
        viewModel.favorites.observe(this) { favorites ->
            renderFavorites(
                favorites = favorites,
                favoritesContainer = favoritesContainer,
                favoritesLayout = favoritesLayout
            )
        }

        viewModel.isLoading.observe(this) { isLoading ->
            progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
            swipeRefresh.isRefreshing = isLoading
        }
        viewModel.errorMessage.observe(this) { message ->
            if (message == null) {
                errorLayout.visibility = View.GONE
            } else {
                textError.text = message
                errorLayout.visibility = View.VISIBLE
            }
        }
        viewModel.loadFavorites(this)

        buttonRetry.setOnClickListener {
            viewModel.loadPokemon()
        }

        swipeRefresh.setOnRefreshListener {
            viewModel.loadPokemon()
        }

        viewModel.loadPokemon()
    }
    private fun renderFavorites(
        favorites: List<PokemonUiModel>,
        favoritesContainer: HorizontalScrollView,
        favoritesLayout: LinearLayout
    ) {
        favoritesLayout.removeAllViews()

        favoritesContainer.visibility = if (favorites.isEmpty()) {
            View.GONE
        } else {
            View.VISIBLE
        }

        favorites.forEach { pokemon ->
            val imageView = ImageView(this).apply {
                layoutParams = LinearLayout.LayoutParams(110, 110).apply {
                    marginEnd = 16
                }
                scaleType = ImageView.ScaleType.FIT_CENTER
                setPadding(4, 4, 4, 4)

                setOnClickListener {
                    val intent = Intent(this@MainActivity, PokemonDetailsActivity::class.java)
                    intent.putExtra("name", pokemon.name)
                    intent.putExtra("image", pokemon.imageUrl)
                    intent.putExtra("height", pokemon.height)
                    intent.putExtra("weight", pokemon.weight)
                    intent.putExtra("hp", pokemon.hp)
                    intent.putExtra("attack", pokemon.attack)
                    intent.putExtra("defense", pokemon.defense)
                    intent.putExtra("speed", pokemon.speed)
                    startActivity(intent)
                }
            }

            Glide.with(this)
                .load(pokemon.imageUrl)
                .into(imageView)

            favoritesLayout.addView(imageView)
        }
    }
}