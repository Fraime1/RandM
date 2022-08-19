package com.fraime.android.rm2.data.storage.network.api

import com.fraime.android.rm2.domain.model.Character
import com.google.gson.annotations.SerializedName

class RickAndMortyResponse {
    @SerializedName("results")
    lateinit var characterList: List<Character>

    lateinit var info : InfoResponse
}