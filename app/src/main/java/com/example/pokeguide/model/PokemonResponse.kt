package com.example.pokeguide.model

import com.google.gson.annotations.SerializedName

//Represents the data of the API

data class PokemonResponse(
    val id: Int,
    val name: String,
    @SerializedName("sprites") val sprites: Sprites
)

data class Sprites(
    @SerializedName("front_default") val imageUrl: String
)
