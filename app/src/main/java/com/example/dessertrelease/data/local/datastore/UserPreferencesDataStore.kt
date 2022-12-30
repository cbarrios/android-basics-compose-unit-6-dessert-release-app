package com.example.dessertrelease.data.local.datastore

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

private const val LAYOUT_PREFERENCE_NAME = "layout_preferences"
val Context.userPrefDataStore: DataStore<Preferences> by preferencesDataStore(
    name = LAYOUT_PREFERENCE_NAME
)

class UserPreferencesDataStore(
    private val dataStore: DataStore<Preferences>
) : LocalUserPreferencesDataSource {

    private companion object {
        val IS_LINEAR_LAYOUT = booleanPreferencesKey("is_linear_layout")
        const val TAG = "UserPreferencesRepo"
    }

    override suspend fun saveLayoutPreference(isLinearLayout: Boolean): Boolean {
        return try {
            dataStore.edit { preferences ->
                preferences[IS_LINEAR_LAYOUT] = isLinearLayout
            }
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    override val isLinearLayout: Flow<Boolean>
        get() = dataStore.data
            .catch {
                if (it is IOException) {
                    Log.e(TAG, "Error reading preferences.", it)
                    emit(emptyPreferences())
                } else {
                    throw it
                }
            }
            .map { preferences ->
                preferences[IS_LINEAR_LAYOUT] ?: true
            }
}