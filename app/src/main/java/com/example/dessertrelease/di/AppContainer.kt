package com.example.dessertrelease.di

import com.example.dessertrelease.data.local.repository.UserPreferencesRepository

interface AppContainer {

    val userPreferencesRepository: UserPreferencesRepository
}