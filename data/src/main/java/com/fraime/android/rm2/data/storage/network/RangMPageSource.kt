package com.fraime.android.rm2.data.storage.network

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.fraime.android.rm2.data.storage.CharacterStorage
import com.fraime.android.rm2.domain.model.Character
import retrofit2.HttpException

private const val TAG = "RangMPageSource"

class RangMPageSource(
    private val characterStorage: CharacterStorage
) : PagingSource<Int, Character>(){
    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        val page: Int = params.key ?: 1
        val response = characterStorage.getPaging().getPagingCharacters(page)
        if (response.isSuccessful) {
            Log.d(TAG, "response received")
            val charactersList = response.body()?.characterList ?: mutableListOf()

            return LoadResult.Page(data = charactersList,
            prevKey = if(page > 1) page - 1 else null,
                nextKey = if (charactersList.isEmpty()) null else page + 1)
        } else {
            return LoadResult.Error(HttpException(response))
        }
    }

}