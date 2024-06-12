package com.alanturing.cpifp.rickandmorty.di

import com.alanturing.cpifp.rickandmorty.data.CharacterDefaultRepository
import com.alanturing.cpifp.rickandmorty.data.CharacterNetworkRepository
import com.alanturing.cpifp.rickandmorty.data.CharacterRepository
import com.alanturing.cpifp.rickandmorty.data.network.RickAndMortyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class NetworkRepository
    @Singleton
    @Provides
    fun provideNetworkApi():RickAndMortyApi {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(RickAndMortyApi::class.java)
    }

    @Singleton
    @NetworkRepository
    @Provides
    fun provideNetworkRepository(api:RickAndMortyApi):CharacterRepository {
        return CharacterNetworkRepository(api)
    }

    @Singleton
    @Provides
    fun provideDefaultRepository(
        @NetworkRepository networkRepository: CharacterRepository
    ):CharacterRepository {
        return CharacterDefaultRepository(networkRepository)
    }
}