package com.example.dessertrelease.data.local.repository

import kotlinx.coroutines.flow.Flow

interface UserPreferencesRepository {

    suspend fun saveLayoutPreference(isLinearLayout: Boolean): Boolean

    val isLinearLayout: Flow<Boolean>
}