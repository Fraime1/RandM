package com.fraime.android.rm2.domain.usecase

import com.fraime.android.rm2.domain.model.Character
import com.fraime.android.rm2.domain.repository.CharacterRepository
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(val characterRepository: CharacterRepository){

    suspend fun execute(id: String) : Deferred<Character?> {
        return characterRepository.getCharacter(id = id)
    }
}