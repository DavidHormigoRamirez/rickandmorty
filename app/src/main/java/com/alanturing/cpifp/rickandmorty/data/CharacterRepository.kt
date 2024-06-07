package com.alanturing.cpifp.rickandmorty.data

import com.alanturing.cpifp.rickandmorty.data.model.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    fun observeCharacters(): Flow<List<Character>>
    suspend fun refreshCharacters()
    suspend fun readCharacter(): Character
}