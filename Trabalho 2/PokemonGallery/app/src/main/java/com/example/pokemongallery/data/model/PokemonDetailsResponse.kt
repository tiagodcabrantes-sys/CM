package com.example.pokemongallery.data.model

import com.google.gson.annotations.SerializedName

data class PokemonDetailsResponse(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val sprites: PokemonSprites,
    val types: List<PokemonTypeSlot>,
    val stats: List<PokemonStatSlot>
)

data class PokemonOtherSprites(
    @SerializedName("official-artwork")
    val officialArtwork: PokemonOfficialArtwork?
)
data class PokemonSprites(
    val front_default: String?,
    val other: PokemonOtherSprites?
)
data class PokemonOfficialArtwork(
    val front_default: String?
)

data class PokemonTypeSlot(
    val slot: Int,
    val type: PokemonType
)

data class PokemonType(
    val name: String
)

data class PokemonStatSlot(
    val base_stat: Int,
    val stat: PokemonStat
)

data class PokemonStat(
    val name: String
)