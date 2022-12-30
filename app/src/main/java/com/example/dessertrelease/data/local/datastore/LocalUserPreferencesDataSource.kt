package com.example.dessertrelease.data.local.datastore

import kotlinx.coroutines.flow.Flow

interface LocalUserPreferencesDataSource {

    suspend fun saveLayoutPreference(isLinearLayout: Boolean): Boolean

    val isLinearLayout: Flow<Boolean>
}