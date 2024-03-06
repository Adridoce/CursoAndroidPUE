package com.cursoandroid.cloudapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cursoandroid.cloudapp.viewmodels.LoginViewModel
import com.cursoandroid.cloudapp.viewmodels.NotesViewModel
import com.cursoandroid.cloudapp.views.login.TabsView
import com.cursoandroid.cloudapp.views.notes.AddNoteView
import com.cursoandroid.cloudapp.views.notes.HomeView

@Composable
fun NavManager(loginViewModel: LoginViewModel, notesViewModel: NotesViewModel) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Login") {

        composable("Login") {
            TabsView(navController, loginViewModel)
        }
        composable("Home") {
            HomeView(navController, notesViewModel)
        }
        composable("AddNoteView") {
            AddNoteView(navController, notesViewModel)
        }
    }
}