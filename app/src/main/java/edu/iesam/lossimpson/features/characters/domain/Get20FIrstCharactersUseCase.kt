package edu.iesam.lossimpson.features.characters.domain

class Get20FIrstCharactersUseCase(private val characterRepository: CharacterRepository) {
    suspend operator fun invoke() : Result<List<Character>> {
        return characterRepository.get20FirstCharacters()
    }
}