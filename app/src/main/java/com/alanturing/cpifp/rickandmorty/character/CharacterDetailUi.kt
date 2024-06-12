package com.alanturing.cpifp.rickandmorty.character

import com.alanturing.cpifp.rickandmorty.data.model.CharacterModel

data class CharacterDetailUi(
    val id: Long,
    val name: String,
    val species: String,
    val image: String,
    val status: String,
    val gender: String
)

fun List<CharacterModel>.asUiModel():List<CharacterDetailUi> {
    return this.map {
        CharacterDetailUi(
            id=it.id,
            name=it.name,
            image=it.image,
            species = it.species,
            status = it.status,
            gender = it.gender )
    }
}

