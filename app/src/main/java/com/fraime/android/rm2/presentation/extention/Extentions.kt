package com.fraime.android.rm2.presentation.extention

import android.content.Context
import com.fraime.android.rm2.di.AppComponent
import com.fraime.android.rm2.presentation.app.App

val Context.appComponent : AppComponent
    get() = when(this) {
        is App -> appComponent
        else -> this.applicationContext.appComponent
    }