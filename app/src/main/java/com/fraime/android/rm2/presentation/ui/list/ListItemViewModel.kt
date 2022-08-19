package com.fraime.android.rm2.presentation.ui.list

import androidx.core.os.bundleOf
import androidx.navigation.NavController
import com.fraime.android.rm2.R
import com.fraime.android.rm2.domain.model.Character
import com.fraime.android.rm2.presentation.ui.details.DetailsFragment
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ListItemViewModel (private val navController: NavController) {


    private val _id: MutableStateFlow<Int?> = MutableStateFlow(0)
    private val _name: MutableStateFlow<String?> = MutableStateFlow("")
    val name: StateFlow<String?> = _name.asStateFlow()
    private val _species: MutableStateFlow<String?> = MutableStateFlow("")
    val species: StateFlow<String?> = _species.asStateFlow()
    private val _gender: MutableStateFlow<String?> = MutableStateFlow("")
    val gender: StateFlow<String?> = _gender.asStateFlow()


    var character: Character? = null
        set(character) {
            field = character
            _id.value = character?.id
            _name.value = character?.name
            _gender.value = character?.gender
            _species.value = character?.species
        }

    fun toDetails() {
        navController.navigate(
            R.id.action_listFragemnt_to_detailsFragment,
            bundleOf(DetailsFragment.ID_KEY to _id.value)
        )
    }
}