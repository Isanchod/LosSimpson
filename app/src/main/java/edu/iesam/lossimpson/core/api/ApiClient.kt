package edu.iesam.lossimpson.core.api

import edu.iesam.lossimpson.features.characters.data.remote.CharacterApiModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    private val BASE_URL = "https://thesimpsonsapi.com/api/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> createService(typeClass: Class<T>) : T{
        return retrofit.create(typeClass)
    }
}