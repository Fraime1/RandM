package com.fraime.android.rm2.presentation.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fraime.android.rm2.domain.usecase.GetCharacterUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import javax.inject.Inject

class DetailsViewModelFactory @AssistedInject constructor(
    @Assisted("id")private val id: String,
    private val getCharacterUseCase: GetCharacterUseCase
    ) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailsViewModel(getCharacterUseCase = getCharacterUseCase, id = id) as T
    }

    @AssistedFactory
    interface Factory {
        fun create(@Assisted("id") id: String): DetailsViewModelFactory
    }
}