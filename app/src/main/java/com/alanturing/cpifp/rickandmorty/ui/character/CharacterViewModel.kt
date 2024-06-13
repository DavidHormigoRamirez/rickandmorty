package com.alanturing.cpifp.rickandmorty.ui.character

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alanturing.cpifp.rickandmorty.data.CharacterRepository
import com.alanturing.cpifp.rickandmorty.data.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(): ViewModel() {
    @Inject
    lateinit var characterRepository: CharacterRepository
    private val _characters: MutableStateFlow<List<CharacterDetailUi>> = MutableStateFlow(listOf())
    val characters: StateFlow<List<CharacterDetailUi>>
        get() = _characters.asStateFlow()

    init {
        viewModelScope.launch {
            characterRepository.observeCharacters().collect {
                result ->
                when (result) {
                    is Result.Error ->  {}
                    Result.Loading -> {}
                    is Result.Success -> {
                        _characters.value = result.data.asUiModel()
                    }
                }
            }
        }
        viewModelScope.launch {
            characterRepository.refreshCharacters()
        }
    }
    suspend fun getCharacter(id:Long): CharacterDetailUi? {
        val result = characterRepository.readCharacter(id)
        return if (result is Result.Success)
            CharacterDetailUi(
                id = result.data.id,
                name = result.data.name,
                image = result.data.image,
                species = result.data.species,
                gender = result.data.gender,
                status = result.data.status
            )
        else null


    }

}