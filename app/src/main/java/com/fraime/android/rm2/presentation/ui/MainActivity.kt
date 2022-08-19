package com.fraime.android.rm2.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.fraime.android.rm2.R
import com.fraime.android.rm2.presentation.app.App
import com.fraime.android.rm2.presentation.extention.appComponent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}