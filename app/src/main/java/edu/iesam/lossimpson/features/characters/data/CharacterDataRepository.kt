package edu.iesam.lossimpson.features.characters.data

import edu.iesam.lossimpson.features.characters.data.remote.CharactersApiRemoteDataSource
import edu.iesam.lossimpson.features.characters.domain.SimpsonCharacter
import edu.iesam.lossimpson.features.characters.domain.CharacterRepository

class CharacterDataRepository(private val charactersApiRemoteDataSource: CharactersApiRemoteDataSource) : CharacterRepository {
    override suspend fun get20FirstCharacters(): Result<List<SimpsonCharacter>> {
        return charactersApiRemoteDataSource.get20FirstCharacters()
    }
}