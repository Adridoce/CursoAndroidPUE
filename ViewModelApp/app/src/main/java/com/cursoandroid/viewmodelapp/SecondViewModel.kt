package com.cursoandroid.viewmodelapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondViewModel(var passedClicks: Int): ViewModel() {

    private val _clicks = MutableLiveData<Int>()
    val clicks: LiveData<Int> get() = _clicks

    init {
        _clicks.value = passedClicks + 1
    }

    fun addClick() {
        _clicks.value = _clicks.value?.plus(1)
    }
}