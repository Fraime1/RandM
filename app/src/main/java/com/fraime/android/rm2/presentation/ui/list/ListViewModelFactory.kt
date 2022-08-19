package com.fraime.android.rm2.presentation.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fraime.android.rm2.domain.usecase.GetCharactersPagingUseCase
import javax.inject.Inject

class ListViewModelFactory @Inject constructor(val getCharactersPagingUseCase: GetCharactersPagingUseCase) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ListViewModel(
            getCharactersPagingUseCase = getCharactersPagingUseCase
        ) as T
    }
}