package com.fraime.android.rm2.domain.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.PagingData
import com.fraime.android.rm2.domain.model.Character
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

interface CharacterRepository {

    fun getCharactersPaging() : Flow<PagingData<Character>>

    suspend fun getCharacter(id: String) : Deferred<Character?>
}