package com.alanturing.cpifp.rickandmorty.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacters(vararg characters: CharacterEntity)

    @Query("SELECT * FROM character WHERE id = :id")
    suspend fun loadCharacterById(id:Long):CharacterEntity

    @Query("SELECT * FROM character")
    fun observeCharacters(): Flow<List<CharacterEntity>>

    @Query("SELECT * FROM character")
    suspend fun getCharacters(): List<CharacterEntity>
}