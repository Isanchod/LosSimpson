package edu.iesam.lossimpson.features.characters.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.iesam.lossimpson.R
import edu.iesam.lossimpson.features.characters.domain.SimpsonCharacter

class CharacterAdapter : RecyclerView.Adapter<CharacterViewHolder>() {

    private val dataList: MutableList<SimpsonCharacter> = mutableListOf()

    fun setDataList(characters: List<SimpsonCharacter>){
        dataList.clear()
        dataList.addAll(characters)
        notifyDataSetChanged()
    }

    fun addDataList(characters: List<SimpsonCharacter>){
        dataList.addAll(characters)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.view_character_item, parent, false)
        return CharacterViewHolder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(dataList[position])
    }
}