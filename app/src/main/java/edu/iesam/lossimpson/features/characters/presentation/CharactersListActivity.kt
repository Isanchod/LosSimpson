package edu.iesam.lossimpson.features.characters.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import edu.iesam.lossimpson.R
import edu.iesam.lossimpson.core.api.ApiClient
import edu.iesam.lossimpson.features.characters.data.CharacterDataRepository
import edu.iesam.lossimpson.features.characters.data.remote.CharactersApiRemoteDataSource
import edu.iesam.lossimpson.features.characters.domain.Get20FIrstCharactersUseCase

class CharactersListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setUpObserver()
        viewModel.load20FirstCharacters()
    }

    private val viewModel = CharactersListViewModel(
        Get20FIrstCharactersUseCase(
            CharacterDataRepository(
                CharactersApiRemoteDataSource(
                    ApiClient()
                )
            )
        )
    )

    private fun setUpObserver(){
        val observer = Observer<CharactersListViewModel.UiState>{ uiState ->
            if (uiState.isLoading){
                //TODO
            } else {
                //TODO
            } ?: {
                //TODO
            }

            uiState.error?.let {
                //TODO
            }

            uiState.characters.let {
                Log.d("@dev", "${uiState.characters}")
            }
        }
        viewModel.uiState.observe(this, observer)
    }
}