package com.cursoandroid.cloudapp.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class NotesViewModel: ViewModel() {

    private val auth: FirebaseAuth = Firebase.auth
    private val firestore = Firebase.firestore

    private val _notesData = MutableStateFlow<List<Any>>(emptyList())
    val notesData: StateFlow<List<Any>> = _notesData

    /*var state by mutableStateOf()
        private set
    */

    fun fetchNotes() {

    }

    fun saveNewNote() {

    }

    fun getNoteById(documentId: String) {

    }

    fun updateNote() {

    }

    fun deleteNote() {

    }

    fun signOut() {
        auth.signOut()
    }

}