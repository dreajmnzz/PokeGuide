package com.example.pokeguide.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokeguide.model.PokemonResponse
import com.example.pokeguide.repository.PokemonRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

//This class handles data for the UI.

class PokemonViewModel : ViewModel() {
    private val repository = PokemonRepository()
    private val pokeList = MutableStateFlow<List<PokemonResponse>>(emptyList())
    val pokemonList: StateFlow<List<PokemonResponse>> = pokeList

    fun fetchPokemonList(range: IntRange) {
        viewModelScope.launch {
            val list = range.mapNotNull { id ->
                try {
                    repository.getPokemon(id)
                } catch (e: Exception) {
                    null
                }
            }
            pokeList.value = list
        }
    }
}