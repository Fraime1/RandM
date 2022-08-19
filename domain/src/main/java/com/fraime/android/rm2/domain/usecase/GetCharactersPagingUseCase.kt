package com.fraime.android.rm2.domain.usecase

import androidx.paging.PagingData
import com.fraime.android.rm2.domain.model.Character
import com.fraime.android.rm2.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharactersPagingUseCase @Inject constructor(val characterRepository: CharacterRepository) {

    fun execute() : Flow<PagingData<Character>> {
        return characterRepository.getCharactersPaging()
    }
}