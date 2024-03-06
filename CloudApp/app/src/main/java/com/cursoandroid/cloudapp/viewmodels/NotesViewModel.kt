package com.cursoandroid.cloudapp.viewmodels

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cursoandroid.cloudapp.models.NotesModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.toObject
import com.google.firebase.ktx.Firebase
import io.grpc.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class NotesViewModel: ViewModel() {

    private val auth: FirebaseAuth = Firebase.auth
    private val firestore = Firebase.firestore

    private val _notesData = MutableStateFlow<List<NotesModel>>(emptyList())
    val notesData: StateFlow<List<NotesModel>> = _notesData

    var state by mutableStateOf(NotesModel())
        private set


    fun fetchNotes() {
        val email = auth.currentUser?.email

        firestore.collection("Notes")
            .whereEqualTo("emailUser", email.toString())
            .addSnapshotListener{ querySnapShot, error ->

                if (error != null) {
                    return@addSnapshotListener
                }
                else {
                    val documents = mutableListOf<NotesModel>()

                    if (querySnapShot != null) {
                        for (document in querySnapShot) {
                            val myDocument = document.toObject(NotesModel::class.java)
                                .copy(documentId = document.id)

                            documents.add(myDocument)
                        }
                    }
                    _notesData.value = documents
                }
            }
    }

    fun saveNewNote(title: String, note: String, onSuccess: () -> Unit) {

        val email = auth.currentUser?.email

        viewModelScope.launch(Dispatchers.IO) {

            try {
                var newNote = hashMapOf(
                    "title" to title,
                    "note" to note,
                    "date" to formatDate(),
                    "emailUser" to email.toString()
                )

                firestore.collection("Notes").add(newNote)
                    .addOnSuccessListener {
                        onSuccess()
                    }

            }
            catch (e: Exception) {
                Log.d("apu", "Error al agregar nota")
            }
        }
    }

    private fun formatDate(): String {
        val currentDate: Date = Calendar.getInstance().time
        val res = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return res.format(currentDate)
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