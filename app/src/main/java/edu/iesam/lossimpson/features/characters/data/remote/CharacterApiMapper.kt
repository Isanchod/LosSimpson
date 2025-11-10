package edu.iesam.lossimpson.features.characters.data.remote

import edu.iesam.lossimpson.features.characters.domain.SimpsonCharacter

fun CharacterApiModel.toModel(): SimpsonCharacter {
    return SimpsonCharacter(
        this.id,
        this.name,
        this.status,
        this.occupation,
        "https://cdn.thesimpsonsapi.com/200${this.portraitPath}"
        )
}
fun ApiResponse.toCharacter(): List<SimpsonCharacter> {
    return this.characters.map {
        it.toModel()
    }
}