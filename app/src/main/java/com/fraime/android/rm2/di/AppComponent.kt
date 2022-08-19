package com.fraime.android.rm2.di

import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import com.fraime.android.rm2.presentation.ui.MainActivity
import com.fraime.android.rm2.presentation.ui.details.DetailsFragment
import com.fraime.android.rm2.presentation.ui.list.ListFragemnt
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(fragment: ListFragemnt)
    fun inject(fragment: DetailsFragment)
}