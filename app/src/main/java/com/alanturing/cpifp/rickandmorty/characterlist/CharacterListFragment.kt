package com.alanturing.cpifp.rickandmorty.characterlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alanturing.cpifp.rickandmorty.databinding.FragmentCharacterListBinding

class CharacterListFragment : Fragment() {
    private lateinit var binding: FragmentCharacterListBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterListBinding.inflate(inflater,container,false)
        return binding.root
    }
}

