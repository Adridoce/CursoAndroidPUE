package com.cursoandroid.viewmodelapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FirstViewModel : ViewModel() {

    private val _message = MutableLiveData<String>()
    val message: LiveData<String> get() = _message

    private val _clicks = MutableLiveData<Int>()
    val clicks: LiveData<Int> get() = _clicks

    // create viewmodel
    init {
        _message.value = ""
        _clicks.value = 0
        Log.i("VMAPP", "ViewModel created")
    }

    // destroy viewmodel
    override fun onCleared() {
        super.onCleared()
        Log.i("VMAPP", "ViewModel destroyed")
    }

    fun hello(name: String) {
        _message.value = "Hola $name"
        _clicks.value = clicks.value?.plus(1)
    }

    fun goodbye(name: String) {
        _message.value = "Adios $name"
        _clicks.value = clicks.value?.plus(1)
    }

}