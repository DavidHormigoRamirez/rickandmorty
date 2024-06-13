package com.alanturing.cpifp.rickandmorty.data

import com.alanturing.cpifp.rickandmorty.data.model.CharacterModel
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    suspend fun getCharacters(): Result<List<CharacterModel>>
    fun observeCharacters(): Flow<Result<List<CharacterModel>>>
    suspend fun refreshCharacters()
    suspend fun readCharacter(id:Long): Result<CharacterModel>

    suspend fun save(characterModel: CharacterModel)
}