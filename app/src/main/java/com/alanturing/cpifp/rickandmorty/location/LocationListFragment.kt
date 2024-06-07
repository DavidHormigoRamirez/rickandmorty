package com.alanturing.cpifp.rickandmorty.location

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alanturing.cpifp.rickandmorty.R
import com.alanturing.cpifp.rickandmorty.databinding.FragmentLocationListBinding


class LocationListFragment : Fragment() {

    private lateinit var binding: FragmentLocationListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLocationListBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }


}