package com.fraime.android.rm2.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.fraime.android.rm2.data.storage.CharacterStorage
import com.fraime.android.rm2.data.storage.network.RangMPageSource
import com.fraime.android.rm2.domain.model.Character
import com.fraime.android.rm2.domain.repository.CharacterRepository
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class CharacterRepositoryImpl(private val characterStorage: CharacterStorage) : CharacterRepository {
    override fun getCharactersPaging(): Flow<PagingData<Character>> {
        return Pager(PagingConfig(pageSize = 20)) {
            RangMPageSource(characterStorage)
        }.flow
    }

    override suspend fun getCharacter(id: String): Deferred<Character?> {
        return characterStorage.getOne(id = id)
    }

}