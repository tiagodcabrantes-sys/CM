package com.example.pokemongallery.data.repository

import com.example.pokemongallery.data.api.RetrofitInstance
import com.example.pokemongallery.data.model.PokemonUiModel

class PokemonRepository {

    suspend fun getPokemonList(limit: Int = 100): List<PokemonUiModel> {
        val listResponse = RetrofitInstance.api.getPokemonList(limit)

        return listResponse.results.map { item ->
            val details = RetrofitInstance.api.getPokemonDetails(item.name)

            val hp = details.stats.firstOrNull { it.stat.name == "hp" }?.base_stat ?: 0
            val attack = details.stats.firstOrNull { it.stat.name == "attack" }?.base_stat ?: 0
            val defense = details.stats.firstOrNull { it.stat.name == "defense" }?.base_stat ?: 0
            val speed = details.stats.firstOrNull { it.stat.name == "speed" }?.base_stat ?: 0

            PokemonUiModel(
                id = details.id,
                name = details.name.replaceFirstChar { it.uppercase() },
                imageUrl = details.sprites.other?.officialArtwork?.front_default
                    ?: details.sprites.front_default.orEmpty(),
                height = details.height,
                weight = details.weight,
                types = details.types.map { it.type.name },

                hp = hp,
                attack = attack,
                defense = defense,
                speed = speed
            )
        }
    }
}