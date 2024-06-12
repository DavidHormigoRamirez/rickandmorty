package com.alanturing.cpifp.rickandmorty.data.network.models

data class CharacterNetwork(
    val id: Long,
    val name: String,
    val status: String,
    val species: String,
    val image: String
)
