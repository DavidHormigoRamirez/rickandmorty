package com.alanturing.cpifp.rickandmorty.data.local

import com.alanturing.cpifp.rickandmorty.data.CharacterRepository
import com.alanturing.cpifp.rickandmorty.data.Result
import com.alanturing.cpifp.rickandmorty.data.model.CharacterModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CharacterLocalRepository @Inject constructor(private val dao:CharacterDao): CharacterRepository {
    override suspend fun getCharacters(): Result<List<CharacterModel>> {
        return Result.Success(dao.getCharacters().asExternalModel())
    }

    override fun observeCharacters(): Flow<Result<List<CharacterModel>>> {
        return dao.observeCharacters().map {
            Result.Success(it.asExternalModel())
        }
    }

    override suspend fun refreshCharacters() {
        // NO-OP
    }

    override suspend fun readCharacter(id: Long): Result<CharacterModel> {
        return withContext(Dispatchers.IO) {
            val characterEntity = dao.loadCharacterById(id)
            return@withContext Result.Success(characterEntity.asExternalModel())
        }
    }

    override suspend fun save(characterModel: CharacterModel) {
        val characterEntity = characterModel.asLocalModel()
        dao.insertCharacters(characterEntity)
    }
}