package com.example.pokemongallery.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemongallery.data.model.PokemonUiModel
import com.example.pokemongallery.data.repository.PokemonRepository
import kotlinx.coroutines.launch
import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainViewModel : ViewModel() {

    private val repository = PokemonRepository()
    private val gson = Gson()

    private var currentList: List<PokemonUiModel> = emptyList()
    private val favoritesQueue = mutableListOf<PokemonUiModel>()

    private val _pokemonList = MutableLiveData<List<PokemonUiModel>>()
    val pokemonList: LiveData<List<PokemonUiModel>> = _pokemonList

    private val _favorites = MutableLiveData<List<PokemonUiModel>>()
    val favorites: LiveData<List<PokemonUiModel>> = _favorites

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    fun loadPokemon() {
        viewModelScope.launch {
            _isLoading.value = true

            try {
                _errorMessage.value = null
                val result = repository.getPokemonList()

                currentList = result.map { pokemon ->
                    pokemon.copy(
                        isFavorite = favoritesQueue.any { it.id == pokemon.id }
                    )
                }

                _pokemonList.value = currentList
                _favorites.value = favoritesQueue

            } catch (e: Exception) {
                e.printStackTrace()
                _errorMessage.value = "Não foi possível carregar os Pokémon. Verifica a internet."
            }

            _isLoading.value = false
        }
    }

    fun toggleFavorite(pokemon: PokemonUiModel, context: Context) {
        val alreadyFavorite = favoritesQueue.any { it.id == pokemon.id }

        if (alreadyFavorite) {
            favoritesQueue.removeAll { it.id == pokemon.id }
        } else {
            if (favoritesQueue.size >= 5) {
                favoritesQueue.removeAt(0)
            }

            favoritesQueue.add(pokemon.copy(isFavorite = true))
        }

        currentList = currentList.map {
            it.copy(isFavorite = favoritesQueue.any { fav -> fav.id == it.id })
        }

        _pokemonList.value = currentList
        _favorites.value = favoritesQueue

        saveFavorites(context)
    }

    fun searchPokemon(query: String) {
        val filteredList = if (query.isBlank()) {
            currentList
        } else {
            currentList.filter {
                it.name.contains(query, ignoreCase = true)
            }
        }

        _pokemonList.value = filteredList
    }
    fun filterByType(type: String?) {
        val filteredList = if (type == null) {
            currentList
        } else {
            currentList.filter { pokemon ->
                pokemon.types.any { it.equals(type, ignoreCase = true) }
            }
        }

        _pokemonList.value = filteredList
    }
    fun sortByNameAsc() {
        _pokemonList.value = _pokemonList.value?.sortedBy { it.name }
    }

    fun sortByNameDesc() {
        _pokemonList.value = _pokemonList.value?.sortedByDescending { it.name }
    }

    fun sortById() {
        _pokemonList.value = _pokemonList.value?.sortedBy { it.id }
    }
    fun loadFavorites(context: Context) {
        val prefs = context.getSharedPreferences("pokemon_prefs", Context.MODE_PRIVATE)
        val json = prefs.getString("favorites", null)

        if (json != null) {
            val type = object : TypeToken<List<PokemonUiModel>>() {}.type
            val savedFavorites: List<PokemonUiModel> = gson.fromJson(json, type)

            favoritesQueue.clear()
            favoritesQueue.addAll(savedFavorites)

            _favorites.value = favoritesQueue
        }
    }

    private fun saveFavorites(context: Context) {
        val prefs = context.getSharedPreferences("pokemon_prefs", Context.MODE_PRIVATE)
        val json = gson.toJson(favoritesQueue)

        prefs.edit()
            .putString("favorites", json)
            .apply()
    }
    fun showFavoritesOnly() {
        _pokemonList.value = favoritesQueue.toList()
    }
    fun showHome() {
        _pokemonList.value = currentList
    }

    fun showFavoritesScreen() {
        _pokemonList.value = favoritesQueue.toList()
    }
}