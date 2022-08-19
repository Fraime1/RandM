package com.fraime.android.rm2.data.storage

import com.fraime.android.rm2.data.storage.network.api.NetworkApi
import com.fraime.android.rm2.domain.model.Character
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.flow.MutableStateFlow


interface CharacterStorage {

    suspend fun getOne(id: String) : Deferred<Character?>

    fun getPaging() : NetworkApi
}