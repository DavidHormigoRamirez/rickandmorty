package com.alanturing.cpifp.rickandmorty.character

import com.alanturing.cpifp.rickandmorty.data.model.CharacterModel

data class CharacterDetailUi(
    val name: String,
    val image: String
)

fun List<CharacterModel>.asUiModel():List<CharacterDetailUi> {
    return this.map {
        CharacterDetailUi(name=it.name,image=it.image)
    }
}

