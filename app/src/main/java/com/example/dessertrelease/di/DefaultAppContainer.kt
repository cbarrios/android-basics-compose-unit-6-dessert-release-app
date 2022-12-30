package com.example.dessertrelease.di

import android.content.Context
import com.example.dessertrelease.data.local.datastore.LocalUserPreferencesDataSource
import com.example.dessertrelease.data.local.datastore.UserPreferencesDataStore
import com.example.dessertrelease.data.local.datastore.userPrefDataStore
import com.example.dessertrelease.data.local.repository.DefaultUserPreferencesRepository
import com.example.dessertrelease.data.local.repository.UserPreferencesRepository

class DefaultAppContainer(private val context: Context) : AppContainer {

    private val localUserPreferencesDataSource: LocalUserPreferencesDataSource by lazy {
        UserPreferencesDataStore(context.userPrefDataStore)
    }

    override val userPreferencesRepository: UserPreferencesRepository by lazy {
        DefaultUserPreferencesRepository(localUserPreferencesDataSource)
    }
}