package com.alanturing.cpifp.rickandmorty.location

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alanturing.cpifp.rickandmorty.R
import com.alanturing.cpifp.rickandmorty.databinding.FragmentLocationDetailBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LocationDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LocationDetailFragment : Fragment() {
    private lateinit var binding: FragmentLocationDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLocationDetailBinding.inflate(
            inflater,
            container,
            false
        )
        return  binding.root
    }

}