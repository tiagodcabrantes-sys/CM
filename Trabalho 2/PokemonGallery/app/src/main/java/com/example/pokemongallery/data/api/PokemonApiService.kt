package com.example.pokemongallery.data.api

import com.example.pokemongallery.data.model.PokemonDetailsResponse
import com.example.pokemongallery.data.model.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApiService {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int = 100
    ): PokemonListResponse

    @GET("pokemon/{name}")
    suspend fun getPokemonDetails(
        @Path("name") name: String
    ): PokemonDetailsResponse
}