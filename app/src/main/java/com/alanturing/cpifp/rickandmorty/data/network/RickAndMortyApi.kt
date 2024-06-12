package com.alanturing.cpifp.rickandmorty.data.network

import com.alanturing.cpifp.rickandmorty.data.network.models.CharacterListResponse
import com.alanturing.cpifp.rickandmorty.data.network.models.CharacterNetwork
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyApi {

    @GET("character")
    suspend fun getCharacters(): Response<CharacterListResponse>

    @GET("character/{id}")
    suspend fun getSingleCharacter(@Path("id") id:Long):Response<CharacterNetwork>
}