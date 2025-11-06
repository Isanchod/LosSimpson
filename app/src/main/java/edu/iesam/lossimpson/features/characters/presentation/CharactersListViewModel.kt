package edu.iesam.lossimpson.features.characters.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.lossimpson.features.characters.domain.ErrorApp
import edu.iesam.lossimpson.features.characters.domain.Get20FIrstCharactersUseCase
import edu.iesam.lossimpson.features.characters.domain.SimpsonCharacter
import kotlinx.coroutines.launch

class CharactersListViewModel(
    private val get20FIrstCharactersUseCase: Get20FIrstCharactersUseCase
) : ViewModel(){

    private val _uiState = MutableLiveData<UiState>()
    val uiState : LiveData<UiState> = _uiState

    fun load20FirstCharacters() {
        viewModelScope.launch {
            _uiState.value = UiState(isLoading = true)
            get20FIrstCharactersUseCase().fold(
                {loadOnSuccess(it)},
                {loadOnFailure(it as ErrorApp)}
            )
        }
    }

    fun loadOnSuccess(characters: List<SimpsonCharacter>) {
        _uiState.value = UiState(characters = characters)
    }

    fun loadOnFailure(errorApp: ErrorApp) {
        _uiState.value = UiState(error = errorApp)
    }

    data class UiState(
        val error: ErrorApp? = null,
        val isLoading : Boolean = false,
        val characters: List<SimpsonCharacter>? = null
        )
}