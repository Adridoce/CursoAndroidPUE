package com.cursoandroid.storeapp

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StoreEmail(private val context: Context) {

    // Companion object permite crear la parte estatica
    companion object {
        // Toda la bolsa de datos
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("DataEmail")
        val EMAIL = stringPreferencesKey("email")
    }

    // DataStore esta basado en clave-valor
    val getEmail: Flow<String> = context.dataStore.data.map { preferences ->
            preferences[EMAIL] ?: ""
        }

    // Una funcion suspend solo se puede llamar desde una corrutina o desde otra funcion suspend
    suspend fun saveEmail(email: String) {
        context.dataStore.edit { preferences ->
            preferences[EMAIL] = email
        }
    }
}