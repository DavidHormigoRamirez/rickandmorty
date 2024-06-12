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
            id = it.id,
            name = it.name,
            status = it.status,
            gender = it.gender,
            image = it.image,
            species = it.species
        )
    }
    return list
}


