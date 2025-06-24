package com.example.ejemplo2composeidgs901

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun OperacionesBasicas() {
    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }
    var operacionSeleccionada by remember { mutableStateOf("Suma") }

    val operaciones = listOf("Suma", "Resta", "Multiplicación", "División")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        TextField(
            value = num1,
            onValueChange = { num1 = it },
            label = { Text("Número 1") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = num2,
            onValueChange = { num2 = it },
            label = { Text("Número 2") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        operaciones.forEach { operacion ->
            Row(
                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = operacionSeleccionada == operacion,
                    onClick = { operacionSeleccionada = operacion }
                )
                Text(text = operacion)
            }
        }

        Button(onClick = {
            val n1 = num1.toFloatOrNull()
            val n2 = num2.toFloatOrNull()
            resultado = if (n1 != null && n2 != null) {
                when (operacionSeleccionada) {
                    "Suma" -> "Resultado: ${n1 + n2}"
                    "Resta" -> "Resultado: ${n1 - n2}"
                    "Multiplicación" -> "Resultado: ${n1 * n2}"
                    "División" -> {
                        if (n2 != 0f) "Resultado: ${n1 / n2}" else "No se puede dividir entre cero"
                    }
                    else -> "Operación no válida"
                }
            } else {
                "Ingrese números válidos"
            }
        }) {
            Text("Calcular")
        }

        Text(text = resultado)
    }
}