package com.alanturing.cpifp.rickandmorty.data

import com.alanturing.cpifp.rickandmorty.data.model.CharacterModel
import kotlinx.coroutines.flow.Flow

class CharacterDefaultRepository(private val networkRepository: CharacterRepository): CharacterRepository {
    override fun observeCharacters(): Flow<Result<List<CharacterModel>>> {
        return networkRepository.observeCharacters()
    }

    override suspend fun refreshCharacters() {
       networkRepository.refreshCharacters()
    }

    override suspend fun readCharacter(id:Long): CharacterModel {
        return networkRepository.readCharacter(id)
    }
}