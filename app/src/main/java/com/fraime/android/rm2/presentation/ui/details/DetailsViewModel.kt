package com.fraime.android.rm2.presentation.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fraime.android.rm2.domain.model.Character
import com.fraime.android.rm2.domain.usecase.GetCharacterUseCase
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val id: String,
    private val getCharacterUseCase: GetCharacterUseCase
    ) : ViewModel() {

    private val _character = MutableSharedFlow<Character?>(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    val character: SharedFlow<Character?> = _character.asSharedFlow()


    private val _image: MutableStateFlow<String?> = MutableStateFlow(null)
    val image: StateFlow<String?> = _image.asStateFlow()
    private val _name: MutableStateFlow<String> = MutableStateFlow("")
    val name: StateFlow<String> = _name.asStateFlow()
    private val _species: MutableStateFlow<String> = MutableStateFlow("")
    val species: StateFlow<String> = _species.asStateFlow()
    private val _gender: MutableStateFlow<String> = MutableStateFlow("")
    val gender: StateFlow<String> = _gender.asStateFlow()
    private val _status: MutableStateFlow<String> = MutableStateFlow("")
    val status: StateFlow<String> = _status.asStateFlow()
    private val _location: MutableStateFlow<String> = MutableStateFlow("")
    val location: StateFlow<String> = _location.asStateFlow()
    private val _episodes: MutableStateFlow<String> = MutableStateFlow("")
    val episodes: StateFlow<String> = _episodes.asStateFlow()

    init {
        viewModelScope.launch {
            _character.emit(getCharacterUseCase.execute(id).await())
            character.collect {
                _name.value = it?.name ?: ""
                _species.value = it?.species ?: ""
                _gender.value = it?.gender ?: ""
                _status.value = it?.status ?: ""
                _location.value = it?.location?.name ?: ""
                _episodes.value = it?.episode?.size.toString()
                _image.value = it?.image ?: ""
            }
        }
    }

}