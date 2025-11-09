package edu.iesam.lossimpson.features.characters.presentation

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import edu.iesam.lossimpson.databinding.ViewCharacterItemBinding
import edu.iesam.lossimpson.features.characters.domain.SimpsonCharacter

class CharacterViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    private lateinit var binding: ViewCharacterItemBinding

    fun bind(model: SimpsonCharacter){
        binding = ViewCharacterItemBinding.bind(view)

        binding.apply {
            image.loadUrl(model.portraitPath)
            name.text = model.name
            status.text = model.status
            ocupation.text = model.ocupation
        }
    }

}