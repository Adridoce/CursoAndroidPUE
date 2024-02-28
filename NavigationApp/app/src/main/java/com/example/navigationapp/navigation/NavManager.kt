package com.example.navigationapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigationapp.views.DetailView
import com.example.navigationapp.views.HomeView

@Composable
fun NavManager() {
    val navController = rememberNavController() // Genera la variable que persiste a los cambios de estado

    NavHost(navController = navController, startDestination = "Home") {

        composable("Home") { // La palabra reservada composable sirve para generar las rutas
            HomeView(navController = navController)
        }

        composable("Detail/{id}/?{opcional}", arguments = listOf(
            navArgument("id") { type = NavType.IntType},
            navArgument("opcional") { type = NavType.StringType}
        )) {
            val id = it.arguments?.getInt("id") ?: 0
            val opcional = it.arguments?.getString("opcional") ?: ""

            DetailView(navController = navController, id, opcional)
        }
    }
}