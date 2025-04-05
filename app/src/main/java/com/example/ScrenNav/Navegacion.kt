package com.example.ScrenNav

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Preview(showBackground = true)
@Composable
fun navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "ScreenA") {
        composable("ScreenA") {
            ScreenA(navController)
        }

        composable(
            route = "ScreenB/{nombre}/{correo}/{profesion}",
            arguments = listOf(
                navArgument("nombre") { type = NavType.StringType },
                navArgument("correo") { type = NavType.StringType },
                navArgument("profesion") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val nombre = backStackEntry.arguments?.getString("nombre") ?: ""
            val correo = backStackEntry.arguments?.getString("correo") ?: ""
            val profesion = backStackEntry.arguments?.getString("profesion") ?: ""
            ScreenB(navController, nombre, correo, profesion)
        }
    }
}
