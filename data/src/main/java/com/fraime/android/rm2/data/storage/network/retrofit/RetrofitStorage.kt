package com.fraime.android.rm2.data.storage.network.retrofit

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.fraime.android.rm2.data.storage.CharacterStorage
import com.fraime.android.rm2.data.storage.network.api.NetworkApi
import com.fraime.android.rm2.domain.model.Character
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.withContext
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

private const val TAG = "RetrofitStorage"

class RetrofitStorage  : CharacterStorage {
    private val networkApi: NetworkApi

    init {
        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        networkApi = retrofit.create(NetworkApi::class.java)
    }

    override suspend fun getOne(id: String): Deferred<Character?> = withContext(Dispatchers.IO){
        val request : Call<Character> = networkApi.getCharacter(id)
        async {
            try {
                val result = request.await()
                return@async result
            } catch (e: Exception) {
                return@async null
            }
        }
    }

    override fun getPaging(): NetworkApi{
        return networkApi
    }
}