package com.alanturing.cpifp.rickandmorty.di

import android.content.Context
import androidx.room.Room
import com.alanturing.cpifp.rickandmorty.data.CharacterDefaultRepository
import com.alanturing.cpifp.rickandmorty.data.network.CharacterNetworkRepository
import com.alanturing.cpifp.rickandmorty.data.CharacterRepository
import com.alanturing.cpifp.rickandmorty.data.local.CharacterDao
import com.alanturing.cpifp.rickandmorty.data.local.CharacterLocalRepository
import com.alanturing.cpifp.rickandmorty.data.local.RickAndMortyDatabase
import com.alanturing.cpifp.rickandmorty.data.network.RickAndMortyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class NetworkRepository

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class LocalRepository

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context):RickAndMortyDatabase {
        val db = Room.databaseBuilder(
            context,
            RickAndMortyDatabase::class.java,
            "randmdb"
        ).build()
        return db
    }

    @Singleton
    @Provides
    fun provideCharacterDao(database:RickAndMortyDatabase) = database.characterDao()

    @Singleton
    @LocalRepository
    @Provides
    fun provideLocalRepository(dao: CharacterDao):CharacterRepository {
        return CharacterLocalRepository(dao)
    }

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
        @NetworkRepository networkRepository: CharacterRepository,
        @LocalRepository localRepository: CharacterRepository
    ):CharacterRepository {
        return CharacterDefaultRepository(networkRepository,localRepository)
    }
}