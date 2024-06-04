package com.geeks.lesson8_month3

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.geeks.lesson8_month3.databinding.FragmentSignInScreenBinding


class CharacterDetailFragment : Fragment() {
    private lateinit var binding: FragmentSignInScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignInScreenBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val character = arguments?.getSerializable("character") as Character
        binding.apply {
            tvCharacterBending.text = character.characterBending
            tvName.text = character.name
            Glide.with(ivCharacter).load(character.image).into(ivCharacter)
        }
    }
}