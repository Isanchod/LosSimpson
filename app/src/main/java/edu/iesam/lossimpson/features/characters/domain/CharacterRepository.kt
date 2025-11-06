package edu.iesam.lossimpson.features.characters.domain

interface CharacterRepository {
    suspend fun get20FirstCharacters():Result<List<SimpsonCharacter>>
}