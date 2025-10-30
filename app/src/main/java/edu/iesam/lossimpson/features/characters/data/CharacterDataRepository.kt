package edu.iesam.lossimpson.features.characters.data

import edu.iesam.lossimpson.features.characters.data.remote.CharactersApiRemoteDataSource
import edu.iesam.lossimpson.features.characters.domain.Character
import edu.iesam.lossimpson.features.characters.domain.CharacterRepository

class CharacterDataRepository(private val charactersApiRemoteDataSource: CharactersApiRemoteDataSource) : CharacterRepository {
    override suspend fun get20FirstCharacters(): Result<List<Character>> {
        return c
    }
}