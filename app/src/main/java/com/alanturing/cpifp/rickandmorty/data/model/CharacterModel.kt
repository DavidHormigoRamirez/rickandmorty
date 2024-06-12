package com.alanturing.cpifp.rickandmorty.data.model

data class CharacterModel(
    val id: Long,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val image: String
)
