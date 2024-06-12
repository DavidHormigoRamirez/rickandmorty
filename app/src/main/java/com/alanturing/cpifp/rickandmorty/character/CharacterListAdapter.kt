package com.alanturing.cpifp.rickandmorty.character

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.alanturing.cpifp.rickandmorty.R
import com.alanturing.cpifp.rickandmorty.databinding.CharacterItemBinding

class CharacterListAdapter(private val context: Context,
    private val toDetail: (id:Long,v:View)->Unit) :
    ListAdapter<CharacterDetailUi, CharacterListAdapter.CharacterCardViewHolder>(CharacterDiffCallback) {

    inner class CharacterCardViewHolder(private val binding: CharacterItemBinding):ViewHolder(binding.root) {

        fun bind(data:CharacterDetailUi) {
            //binding.characterImage = data.image
            binding.characterName.text = data.name
            binding.characterImage.load(data.image)
            binding.root.setOnClickListener {
                toDetail(data.id,binding.root)
            }
        }
    }

    object CharacterDiffCallback: DiffUtil.ItemCallback<CharacterDetailUi>() {
        override fun areItemsTheSame(
            oldItem: CharacterDetailUi,
            newItem: CharacterDetailUi
        ): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(
            oldItem: CharacterDetailUi,
            newItem: CharacterDetailUi
        ): Boolean {
            return oldItem.image == newItem.image && oldItem.name == newItem.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterCardViewHolder {
        return CharacterCardViewHolder(CharacterItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: CharacterCardViewHolder, position: Int) {
            holder.bind(getItem(position))
    }
}