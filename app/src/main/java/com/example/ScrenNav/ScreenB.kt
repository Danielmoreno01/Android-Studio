package com.example.ScrenNav

import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun ScreenB(navController: NavController, nombre: String, correo: String, profesion: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Bienbreniv@")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Nombre: ${Uri.decode(nombre)}")
        Text(text = "Correo: ${Uri.decode(correo)}")
        Text(text = "Profesión: ${Uri.decode(profesion)}")

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Volver")
        }
    }
}
