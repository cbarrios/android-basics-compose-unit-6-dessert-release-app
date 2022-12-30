package com.example.dessertrelease

import android.app.Application
import com.example.dessertrelease.di.AppContainer
import com.example.dessertrelease.di.DefaultAppContainer

class DessertReleaseApplication : Application() {
    lateinit var appContainer: AppContainer

    override fun onCreate() {
        super.onCreate()
        appContainer = DefaultAppContainer(this)
    }
}

