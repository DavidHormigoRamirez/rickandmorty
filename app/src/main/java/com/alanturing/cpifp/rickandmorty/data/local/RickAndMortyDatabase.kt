package com.alanturing.cpifp.rickandmorty.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CharacterEntity::class], version = 1)
abstract class RickAndMortyDatabase:RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}