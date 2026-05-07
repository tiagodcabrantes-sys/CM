package com.example.pokemongallery.data.model

data class PokemonUiModel(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val height: Int,
    val weight: Int,
    val types: List<String> = emptyList(),
    val hp: Int = 0,
    val attack: Int = 0,
    val defense: Int = 0,
    val speed: Int = 0,
    val isFavorite: Boolean = false
)
