package com.cursoandroid.cloudapp.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch
import java.lang.Exception

class LoginViewModel : ViewModel() {

    private val auth: FirebaseAuth = Firebase.auth
    var showAlert by mutableStateOf(false)

    fun login(email: String, password: String, onSucces: () -> Unit) {
        viewModelScope.launch {
            try {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            onSucces()
                        }
                        else {
                            Log.d("apu", "Usuario o contraseña incorrectos")
                            showAlert = true
                        }
                    }
            }
            catch (e: Exception) {
                Log.d("apu", "Error general Firebase")
            }

        }
    }

    fun register(email: String, password: String, username: String, onSucces: () -> Unit) {
        viewModelScope.launch {
            try {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            // TODO: persistir en base de datos cloud
                            onSucces()
                        }
                        else {
                            Log.d("apu", "Error en creacion de usuario")
                            showAlert = true
                        }
                    }
            }
            catch (e: Exception) {
                Log.d("apu", "Error general Firebase")
            }

        }
    }

    fun closeAlert() {
        showAlert = false
    }
}