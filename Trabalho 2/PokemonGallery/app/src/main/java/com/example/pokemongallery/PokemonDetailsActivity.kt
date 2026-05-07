package com.example.pokemongallery

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import android.widget.ProgressBar

class PokemonDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_details)

        val image = findViewById<ImageView>(R.id.detailImage)
        val name = findViewById<TextView>(R.id.detailName)
        val types = findViewById<TextView>(R.id.detailTypes)
        val height = findViewById<TextView>(R.id.detailHeight)
        val weight = findViewById<TextView>(R.id.detailWeight)
        val favorite = findViewById<TextView>(R.id.detailFavorite)
        val hp = findViewById<TextView>(R.id.detailHp)
        val attack = findViewById<TextView>(R.id.detailAttack)
        val defense = findViewById<TextView>(R.id.detailDefense)
        val speed = findViewById<TextView>(R.id.detailSpeed)
        val progressHp = findViewById<ProgressBar>(R.id.progressHp)
        val progressAttack = findViewById<ProgressBar>(R.id.progressAttack)
        val progressDefense = findViewById<ProgressBar>(R.id.progressDefense)
        val progressSpeed = findViewById<ProgressBar>(R.id.progressSpeed)

        val pokemonName = intent.getStringExtra("name") ?: ""
        val pokemonImage = intent.getStringExtra("image") ?: ""
        val pokemonHeight = intent.getIntExtra("height", 0)
        val pokemonWeight = intent.getIntExtra("weight", 0)
        val pokemonTypes = intent.getStringExtra("types") ?: ""
        val pokemonFavorite = intent.getBooleanExtra("isFavorite", false)
        val pokemonHp = intent.getIntExtra("hp", 0)
        val pokemonAttack = intent.getIntExtra("attack", 0)
        val pokemonDefense = intent.getIntExtra("defense", 0)
        val pokemonSpeed = intent.getIntExtra("speed", 0)

        name.text = pokemonName
        types.text = "Types: $pokemonTypes"
        height.text = "Height: $pokemonHeight"
        weight.text = "Weight: $pokemonWeight"
        favorite.text = if (pokemonFavorite) "★" else "☆"
        hp.text = "HP: $pokemonHp"
        attack.text = "Attack: $pokemonAttack"
        defense.text = "Defense: $pokemonDefense"
        speed.text = "Speed: $pokemonSpeed"
        progressHp.progress = pokemonHp
        progressAttack.progress = pokemonAttack
        progressDefense.progress = pokemonDefense
        progressSpeed.progress = pokemonSpeed

        Glide.with(this)
            .load(pokemonImage)
            .into(image)
    }
}