package edu.iesam.lossimpson.features.characters.presentation

import androidx.recyclerview.widget.DiffUtil
import edu.iesam.lossimpson.features.characters.domain.SimpsonCharacter

class CharacterDiffUtil : DiffUtil.ItemCallback<SimpsonCharacter>(){
    override fun areItemsTheSame(
        oldItem: SimpsonCharacter,
        newItem: SimpsonCharacter
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: SimpsonCharacter,
        newItem: SimpsonCharacter
    ): Boolean {
        return oldItem == newItem
    }

}