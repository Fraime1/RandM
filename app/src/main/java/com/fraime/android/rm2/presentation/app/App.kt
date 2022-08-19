package com.fraime.android.rm2.presentation.app

import android.app.Application
import com.fraime.android.rm2.di.AppComponent
import com.fraime.android.rm2.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}