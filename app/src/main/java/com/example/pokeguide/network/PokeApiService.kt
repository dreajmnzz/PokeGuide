package com.example.pokeguide.network

import com.example.pokeguide.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path

//API interface

interface PokeApiService {
    @GET("pokemon/{id}")
    suspend fun getPokemon(@Path("id") id: Int): PokemonResponse
}