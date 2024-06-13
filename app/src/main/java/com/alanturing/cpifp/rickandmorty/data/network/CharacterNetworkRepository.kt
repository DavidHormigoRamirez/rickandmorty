package com.alanturing.cpifp.rickandmorty.data.network

import com.alanturing.cpifp.rickandmorty.data.CharacterRepository
import com.alanturing.cpifp.rickandmorty.data.Result
import com.alanturing.cpifp.rickandmorty.data.model.CharacterModel
import com.alanturing.cpifp.rickandmorty.data.network.models.asCharacter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


class CharacterNetworkRepository @Inject constructor(private val api: RickAndMortyApi):
    CharacterRepository {
    private val _characters: MutableStateFlow<Result<List<CharacterModel>>>  = MutableStateFlow(
        Result.Loading
    )

    override suspend fun getCharacters(): Result<List<CharacterModel>> {
    return try {
        val response = api.getCharacters()
        return if (response.isSuccessful) {
            Result.Success<List<CharacterModel>>(response.body()!!.results.asCharacter())
        }
        else {
            Result.Error(response.errorBody().toString())
        }}
        catch (_:Throwable) {Result.Error("")}

    }


    override fun observeCharacters(): Flow<Result<List<CharacterModel>>> = _characters.asStateFlow()

    override suspend fun refreshCharacters() {
        _characters.value = getCharacters()
    }

    override suspend fun readCharacter(id:Long): Result<CharacterModel> {
        val response = api.getSingleCharacter(id)

        return if (response.isSuccessful) {
            Result.Success<CharacterModel>(
                CharacterModel(
                    id = response.body()!!.id,
                    name = response.body()!!.name,
                    status = response.body()!!.status,
                    image = response.body()!!.image,
                    gender = response.body()!!.gender,
                    species = response.body()!!.species

                )
            )
        } else {
            Result.Error("No encontrado")
        }
    }

    override suspend fun save(characterModel: CharacterModel) {
        TODO("Not yet implemented")
    }
}