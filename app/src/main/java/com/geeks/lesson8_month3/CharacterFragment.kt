package com.geeks.lesson8_month3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.geeks.lesson8_month3.databinding.FragmentCharacterBinding

class CharacterFragment : Fragment() {
    private lateinit var binding: FragmentCharacterBinding
    private val character = listOf(
        Character(
            "Air Bending",
            "Avatar Aang",
            "https://static.wikia.nocookie.net/avatar/images/a/ae/Aang_at_Jasmine_Dragon.png/revision/latest/top-crop/width/200/height/150?cb=20130612174003"
        ),
        Character(
            "Water Bending",
            "Katara",
            "https://static.wikia.nocookie.net/avatar/images/7/7a/Katara_smiles_at_coronation.png/revision/latest/top-crop/width/200/height/150?cb=20150104171449"
        ),
        Character(
            "Earth Bending",
            "Toph",
            "https://static.wikia.nocookie.net/avatar/images/4/46/Toph_Beifong.png/revision/latest/top-crop/width/200/height/150?cb=20131230122047"
        ),
        Character(
            "Fire Bending",
            "Zuko",
            "https://static.wikia.nocookie.net/avatar/images/4/4b/Zuko.png/revision/latest/top-crop/width/200/height/150?cb=20180630112142"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iniAdapter()
    }

    private fun iniAdapter() {
        val adapter = CharacterAdapter(character, this::onClick)
        binding.rvCharacter.adapter = adapter
    }

    private fun onClick(characterModel: Character) {
        findNavController().navigate(R.id.singInScreenFragment, bundleOf("character" to characterModel))
    }



}