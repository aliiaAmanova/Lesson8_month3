package com.geeks.lesson8_month3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.geeks.lesson8_month3.databinding.ItemCharacterBinding


class CharacterAdapter(
    private val characterList: List<Character>,
    val onClick: (model: Character) -> Unit
) :
    RecyclerView.Adapter<CharacterAdapter.ViewHolderCharacter>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCharacter {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemCharacterBinding.inflate(layoutInflater, parent, false)
        return ViewHolderCharacter(binding)
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    override fun onBindViewHolder(holder: ViewHolderCharacter, position: Int) {
        holder.bind(characterList[position])
    }

    inner class ViewHolderCharacter(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(characterModel: Character) {
            binding.apply {
                characterModel.apply {
                    characterBending.text = characterBending
                    name.text= name
                    Glide.with(imgCharacter).load(image).into(binding.imgCharacter)
                    itemView.setOnClickListener {
                        onClick.invoke(characterModel)
                    }
                }
            }
        }
    }
}
