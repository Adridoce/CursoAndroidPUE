package com.cursoandroid.cloudapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.cursoandroid.cloudapp.navigation.NavManager
import com.cursoandroid.cloudapp.ui.theme.CloudAppTheme
import com.cursoandroid.cloudapp.viewmodels.LoginViewModel
import com.cursoandroid.cloudapp.viewmodels.NotesViewModel
import com.cursoandroid.cloudapp.views.login.TabsView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val loginVM: LoginViewModel by viewModels()
        val notesVM: NotesViewModel by viewModels()


        setContent {
            CloudAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavManager(loginVM, notesVM)
                }
            }
        }
    }
}

