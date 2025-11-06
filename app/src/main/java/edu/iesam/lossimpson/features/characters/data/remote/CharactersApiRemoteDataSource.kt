package edu.iesam.lossimpson.features.characters.data.remote

import edu.iesam.lossimpson.core.api.ApiClient
import edu.iesam.lossimpson.features.characters.domain.ErrorApp
import edu.iesam.lossimpson.features.characters.domain.SimpsonCharacter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharactersApiRemoteDataSource (private val apiClient: ApiClient) {
    suspend fun get20FirstCharacters(): Result<List<SimpsonCharacter>> {
        return withContext(Dispatchers.IO) {
            val apiService = apiClient.createService(CharacterApiService::class.java)
            val apiResponse = apiService.findFirst20Characters()
            if(apiResponse.isSuccessful && apiResponse.errorBody() == null){
                Result.success( apiResponse.body()!!.toCharacter()
                )
            } else {
                Result.failure(ErrorApp.ApiError)
            }
        }
    }
}