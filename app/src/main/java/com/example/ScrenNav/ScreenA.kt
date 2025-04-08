package com.example.ScrenNav

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ScreenA(navController: NavController) {
    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var profesion by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre") })
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = correo, onValueChange = { correo = it }, label = { Text("Correo") })
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = profesion, onValueChange = { profesion = it }, label = { Text("Profesión") })
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            registros.add(Registro(nombre, correo, profesion))
            nombre = ""
            correo = ""
            profesion = ""
            navController.navigate("ScreenB")
        }) {
            Text("Enviar")
        }
    }
}
