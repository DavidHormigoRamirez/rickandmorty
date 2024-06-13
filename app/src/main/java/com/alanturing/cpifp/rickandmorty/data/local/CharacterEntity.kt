package com.alanturing.cpifp.rickandmorty.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alanturing.cpifp.rickandmorty.data.model.CharacterModel

@Entity(tableName = "character")
data class CharacterEntity(
    @PrimaryKey
    val id: Long,
    val name:String,
    val status:String,
    val image:String,
    val gender:String,
    val species:String
)

fun CharacterModel.asLocalModel():CharacterEntity {
    return CharacterEntity(
        id = this.id,
        name = this.name,
        image = this.image,
        gender = this.gender,
        status = this.status,
        species = this.species
    )
}
fun CharacterEntity.asExternalModel():CharacterModel {
    return CharacterModel(
        id = this.id,
        name = this.name,
        image = this.image,
        gender = this.gender,
        status = this.status,
        species = this.species
    )
}

fun List<CharacterEntity>.asExternalModel():List<CharacterModel> {
    return this.map {
        it.asExternalModel()
    }
}
