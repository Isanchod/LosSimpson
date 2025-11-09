package edu.iesam.lossimpson.features.characters.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import edu.iesam.lossimpson.R
import edu.iesam.lossimpson.features.characters.domain.SimpsonCharacter

class CharacterAdapter : ListAdapter<SimpsonCharacter, CharacterViewHolder>(CharacterDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.view_character_item, parent, false)
        return CharacterViewHolder(view)
    }

    override fun getItemCount(): Int = currentList.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}