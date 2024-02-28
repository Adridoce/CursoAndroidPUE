package com.example.coroutinesapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    var resultState by mutableStateOf("")
        private set

    var isLoading by mutableStateOf(false)
        private set

    fun fetchData() {
        viewModelScope.launch {
            try {
                isLoading = true
                llamarApi()
            } catch (e: Exception) {

            } finally {
                isLoading = false
            }
        }
    }

    private suspend fun llamarApi() {
        val resultado = withContext(Dispatchers.IO) {
            delay(5000)
            "Items de respuesta del API tras 5 segundos"
        }

        resultState = resultado
    }
}