package com.example.pokemongallery.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokemongallery.R
import com.example.pokemongallery.data.model.PokemonUiModel
import com.google.android.material.card.MaterialCardView
import android.graphics.Color

class PokemonAdapter(
    private var pokemonList: List<PokemonUiModel>,
    private val onItemClick: (PokemonUiModel) -> Unit,
    private val onFavoriteClick: (PokemonUiModel) -> Unit
) : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    class PokemonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imagePokemon: ImageView = view.findViewById(R.id.imagePokemon)
        val textName: TextView = view.findViewById(R.id.textName)
        val textHeight: TextView = view.findViewById(R.id.textHeight)
        val textWeight: TextView = view.findViewById(R.id.textWeight)
        val buttonFavorite: TextView = view.findViewById(R.id.buttonFavorite)

        val card: MaterialCardView = view as MaterialCardView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pokemon, parent, false)

        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = pokemonList[position]

        val mainType = pokemon.types.firstOrNull()

        val cardColor = when (mainType) {
            "fire" -> "#FFE0D6"
            "water" -> "#D6ECFF"
            "grass" -> "#DDF7DD"
            "electric" -> "#FFF5C2"
            "psychic" -> "#F8D6FF"
            "ice" -> "#DDFBFF"
            "dragon" -> "#E4D9FF"
            "dark" -> "#D8D8D8"
            "fairy" -> "#FFDDF0"
            "poison" -> "#EBD6FF"
            "ground" -> "#F3E0C0"
            "rock" -> "#E0D3B8"
            "bug" -> "#EAF5C0"
            "fighting" -> "#FFD6D6"
            "ghost" -> "#E8DFFF"
            "normal" -> "#EEEEEE"
            else -> "#FFFFFF"
        }

        holder.card.setCardBackgroundColor(Color.parseColor(cardColor))

        holder.textName.text = pokemon.name
        holder.textHeight.text = "Height: ${pokemon.height}"
        holder.textWeight.text = "Weight: ${pokemon.weight}"
        holder.buttonFavorite.text = if (pokemon.isFavorite) "★" else "☆"

        Glide.with(holder.itemView.context)
            .load(pokemon.imageUrl)
            .into(holder.imagePokemon)

        holder.itemView.setOnClickListener {
            onItemClick(pokemon)
        }

        holder.buttonFavorite.setOnClickListener {
            onFavoriteClick(pokemon)
        }
    }

    override fun getItemCount(): Int = pokemonList.size

    fun updateList(newList: List<PokemonUiModel>) {
        pokemonList = newList
        notifyDataSetChanged()
    }
}