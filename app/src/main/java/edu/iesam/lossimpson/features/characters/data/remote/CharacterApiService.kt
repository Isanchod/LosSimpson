package edu.iesam.lossimpson.features.characters.data.remote

import edu.iesam.lossimpson.features.characters.domain.SimpsonCharacter
import retrofit2.Response
import retrofit2.http.GET

interface CharacterApiService {

    @GET("characters")
    suspend fun findFirst20Characters(): Response<ApiResponse>
}