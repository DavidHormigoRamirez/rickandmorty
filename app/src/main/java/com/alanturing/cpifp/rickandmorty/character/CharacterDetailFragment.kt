package com.alanturing.cpifp.rickandmorty.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import coil.load
import com.alanturing.cpifp.rickandmorty.databinding.FragmentCharacterDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharacterDetailFragment():Fragment() {
    private lateinit var binding: FragmentCharacterDetailBinding
    private val arguments: CharacterDetailFragmentArgs by navArgs()
    private val viewModel: CharacterViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterDetailBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments.id
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getCharacter(id)?.let {
                binding.detailToolbar.title = it.name
                binding.characterImage.load(it.image)
                binding.characterSpecies.text = it.species
                binding.characterStatus.text = it.status
                binding.characterGender.text = it.gender
            }

        }



    }
}

