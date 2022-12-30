package com.example.dessertrelease.data.local.repository

import com.example.dessertrelease.data.local.datastore.LocalUserPreferencesDataSource
import kotlinx.coroutines.flow.Flow

class DefaultUserPreferencesRepository(
    private val dataSource: LocalUserPreferencesDataSource
) : UserPreferencesRepository {
    override suspend fun saveLayoutPreference(isLinearLayout: Boolean): Boolean =
        dataSource.saveLayoutPreference(isLinearLayout)

    override val isLinearLayout: Flow<Boolean>
        get() = dataSource.isLinearLayout
}