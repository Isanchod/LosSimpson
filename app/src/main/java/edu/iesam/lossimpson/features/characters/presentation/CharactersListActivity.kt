package edu.iesam.lossimpson.features.characters.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import edu.iesam.lossimpson.R
import edu.iesam.lossimpson.core.api.ApiClient
import edu.iesam.lossimpson.databinding.ActivityMainBinding
import edu.iesam.lossimpson.features.characters.data.CharacterDataRepository
import edu.iesam.lossimpson.features.characters.data.remote.CharactersApiRemoteDataSource
import edu.iesam.lossimpson.features.characters.domain.Get20FIrstCharactersUseCase
import edu.iesam.lossimpson.features.characters.domain.SimpsonCharacter

class CharactersListActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val characterAdapter = CharacterAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setUpBinding()
        setUpView()
        setUpObserver()
        viewModel.load20FirstCharacters()

    }

    private fun setUpBinding(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setUpView(){
        binding.apply {
            list.layoutManager = LinearLayoutManager(
                this@CharactersListActivity,
                LinearLayoutManager.VERTICAL,
                false
            )
            list.adapter = characterAdapter
        }
    }

    private fun bind(characters: List<SimpsonCharacter>){
        characterAdapter.submitList(characters)
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

            uiState.characters?.let {
                Log.d("@dev", "${uiState.characters}")
                bind(it)
            }
        }
        viewModel.uiState.observe(this, observer)
    }
}