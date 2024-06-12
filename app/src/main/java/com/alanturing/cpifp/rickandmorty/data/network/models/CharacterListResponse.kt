package com.alanturing.cpifp.rickandmorty.data.network.models

data class CharacterListResponse(
    val info: CharacterListInfo,
    val results: List<CharacterNetwork>
)

data class CharacterListInfo(
    val count:Long,
    val pages:Long,
    val next:String?,
    val prev:String?
)

fun List<CharacterNetwork>.asCharacter():List<com.alanturing.cpifp.rickandmorty.data.model.CharacterModel> {
    val list = this.map {
        com.alanturing.cpifp.rickandmorty.data.model.CharacterModel(
            it.id,
            it.name,
            it.status,
            it.species,
            it.name,
            it.image
        )
    }
    return list
}


