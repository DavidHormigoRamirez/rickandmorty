package com.alanturing.cpifp.rickandmorty.data

import android.net.NetworkCapabilities
import android.net.NetworkCapabilities.NET_CAPABILITY_VALIDATED
import com.alanturing.cpifp.rickandmorty.data.local.CharacterLocalRepository
import com.alanturing.cpifp.rickandmorty.data.model.CharacterModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class CharacterDefaultRepository(
    private val networkRepository: CharacterRepository,
    private val localRepository: CharacterRepository,
    private val networkCapabilities: NetworkCapabilities?
): CharacterRepository {
    override suspend fun getCharacters(): Result<List<CharacterModel>> {
        withContext(Dispatchers.IO) {
            refreshCharacters()
        }
        // NO -OP
        return withContext(Dispatchers.IO) {
            return@withContext localRepository.getCharacters()
        }

    }

    override fun observeCharacters(): Flow<Result<List<CharacterModel>>> {
        return localRepository.observeCharacters()
    }

    override suspend fun refreshCharacters() {
        networkCapabilities?.let {
            if (it.hasCapability(NET_CAPABILITY_VALIDATED)) {
                updateCharactersFromRemote()
            }
        }

    }

    private suspend fun updateCharactersFromRemote() {
        val characters = networkRepository.getCharacters()
        if (characters is Result.Success) {
            characters.data.forEach {
                localRepository.save(it)
            }
        }
    }

    override suspend fun readCharacter(id:Long): Result<CharacterModel> {
        return localRepository.readCharacter(id)
    }

    override suspend fun save(characterModel: CharacterModel) {
        // NO-OP
    }
}