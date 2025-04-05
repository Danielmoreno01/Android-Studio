package com.example.menus


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DropdownMenuExample() {
    val colors = listOf(
        Color.Red,
        Color.Green,
        Color.Blue,
        Color.Magenta,
        Color(0xFF000000)
    )
    val colorNames = listOf("Rojo", "Verde", "Azul", "Magenta", "Naranja")

    val fonts = listOf(
        FontFamily.Serif,
        FontFamily.SansSerif,
        FontFamily.Monospace,
        FontFamily.Cursive,
        FontFamily.Default
    )
    val fontNames = listOf("Serif", "SansSerif", "Monospace", "Cursive", "Default")

    var selectedColor by remember { mutableStateOf(colors[0]) }
    var selectedFont by remember { mutableStateOf(fonts[0]) }
    var selectedColorName by remember { mutableStateOf(colorNames[0]) }
    var selectedFontName by remember { mutableStateOf(fontNames[0]) }

    var expandedColor by remember { mutableStateOf(false) }
    var expandedFont by remember { mutableStateOf(false) }

    var text by remember { mutableStateOf("HOLA") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Texto") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box {
            OutlinedTextField(
                value = selectedColorName,
                onValueChange = {},
                readOnly = true,
                label = { Text("Seleccionar color") },
                modifier = Modifier.fillMaxWidth()
            )

            Box(
                modifier = Modifier
                    .matchParentSize()
                    .clickable { expandedColor = true }
            )

            DropdownMenu(
                expanded = expandedColor,
                onDismissRequest = { expandedColor = false }
            ) {
                colorNames.forEachIndexed { index, name ->
                    DropdownMenuItem(
                        text = { Text(name) },
                        onClick = {
                            selectedColor = colors[index]
                            selectedColorName = name
                            expandedColor = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Box {
            OutlinedTextField(
                value = selectedFontName,
                onValueChange = {},
                readOnly = true,
                label = { Text("Fuentes") },
                modifier = Modifier.fillMaxWidth()
            )

            Box(
                modifier = Modifier
                    .matchParentSize()
                    .clickable { expandedFont = true }
            )

            DropdownMenu(
                expanded = expandedFont,
                onDismissRequest = { expandedFont = false }
            ) {
                fontNames.forEachIndexed { index, name ->
                    DropdownMenuItem(
                        text = { Text(name) },
                        onClick = {
                            selectedFont = fonts[index]
                            selectedFontName = name
                            expandedFont = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = text,
            fontSize = 24.sp,
            color = selectedColor,
            fontFamily = selectedFont
        )
    }
}
