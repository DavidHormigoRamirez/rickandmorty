package com.alanturing.cpifp.rickandmorty.data

import com.alanturing.cpifp.rickandmorty.data.model.CharacterModel
import com.alanturing.cpifp.rickandmorty.data.network.RickAndMortyApi
import com.alanturing.cpifp.rickandmorty.data.network.models.asCharacter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


class CharacterNetworkRepository @Inject constructor(private val api: RickAndMortyApi):CharacterRepository {
    private val _characters: MutableStateFlow<Result<List<CharacterModel>>>  = MutableStateFlow(Result.Loading)
   override fun observeCharacters(): Flow<Result<List<CharacterModel>>> = _characters.asStateFlow()

    override suspend fun refreshCharacters() {
        val response = api.getCharacters()
        _characters.value = if (response.isSuccessful) {

            Result.Success<List<CharacterModel>>(response.body()!!.results.asCharacter())
        }
        else {
           Result.Error(response.errorBody().toString())
        }
    }

    override suspend fun readCharacter(id:Long): CharacterModel {
        TODO("Not yet implemented")
    }
}