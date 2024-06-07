package com.alanturing.cpifp.rickandmorty.data

import javax.inject.Singleton
import com.alanturing.cpifp.rickandmorty.data.model.Character
import kotlinx.coroutines.flow.Flow

@Singleton
class CharacterNetworkRepository:CharacterRepository {
    override fun observeCharacters(): Flow<List<Character>> {
        TODO("Not yet implemented")
    }

    override suspend fun refreshCharacters() {
        TODO("Not yet implemented")
    }

    override suspend fun readCharacter(): Character {
        TODO("Not yet implemented")
    }
}