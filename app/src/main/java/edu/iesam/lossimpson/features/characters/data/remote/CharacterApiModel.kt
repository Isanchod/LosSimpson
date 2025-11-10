package edu.iesam.lossimpson.features.characters.data.remote

import com.google.gson.annotations.SerializedName

data class CharacterApiModel(
    val id: String,
    val name: String,
    val status: String,
    val occupation: String,
    @SerializedName("portrait_path")
    val portraitPath : String
)

data class ApiResponse(
    @SerializedName("results")
    val characters: List<CharacterApiModel>
)

