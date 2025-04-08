package com.example.ScrenNav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
data class Registro(val nombre: String, val correo: String, val profesion: String)
val registros = mutableListOf<Registro>()

@Composable
fun navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "ScreenA") {
        composable("ScreenA") {
            ScreenA(navController)
        }
        composable("ScreenB") {
            ScreenB(navController)
        }
    }
}
