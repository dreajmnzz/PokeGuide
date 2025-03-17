package com.example.pokeguide.repository

import com.example.pokeguide.model.PokemonResponse
import com.example.pokeguide.network.RetrofitInstance

//This class handles the logic of data retrieval.

class PokemonRepository {
    suspend fun getPokemon(id: Int): PokemonResponse {
        return RetrofitInstance.api.getPokemon(id)
    }
}