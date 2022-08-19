package com.fraime.android.rm2.presentation.ui.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.fraime.android.rm2.domain.model.Character
import com.fraime.android.rm2.domain.usecase.GetCharactersPagingUseCase
import kotlinx.coroutines.flow.*

class ListViewModel(getCharactersPagingUseCase: GetCharactersPagingUseCase) : ViewModel() {

    val listCharacter: StateFlow<PagingData<Character>> =
        getCharactersPagingUseCase.execute().cachedIn(viewModelScope)
            .stateIn(viewModelScope, SharingStarted.Lazily, PagingData.empty())


}