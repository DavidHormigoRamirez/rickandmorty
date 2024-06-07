package com.alanturing.cpifp.rickandmorty.characterdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alanturing.cpifp.rickandmorty.databinding.FragmentCharacterDetailBinding


class CharacterDetailFragment():Fragment() {
    private lateinit var binding: FragmentCharacterDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}

