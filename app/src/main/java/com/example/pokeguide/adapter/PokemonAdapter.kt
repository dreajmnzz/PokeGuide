package com.example.pokeguide.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.PokeGuide.R
import com.example.pokeguide.model.PokemonResponse

//This class manages the list of Pokémon in RecyclerView.

class PokemonAdapter : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    private val pokemonList = mutableListOf<PokemonResponse>()

    fun updateList(newList: List<PokemonResponse>) {
        pokemonList.clear()
        pokemonList.addAll(newList)
        notifyDataSetChanged() // Refresca la lista
    }

    class PokemonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textViewName: TextView = view.findViewById(R.id.textViewPokemonName)
        private val imageViewPokemon: ImageView = view.findViewById(R.id.imageViewPokemon)

        fun bind(pokemon: PokemonResponse) {
            textViewName.text = pokemon.name
            imageViewPokemon.load(pokemon.sprites.imageUrl)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(pokemonList[position])
    }

    override fun getItemCount(): Int = pokemonList.size
}