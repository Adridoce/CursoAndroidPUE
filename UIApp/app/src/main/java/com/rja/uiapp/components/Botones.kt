package com.rja.uiapp.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BotonNormal() {
    Button(onClick = { /*TODO*/ }, enabled = false) {
        Text(text = "Boton normal", fontSize = 30.sp)
    }
}

@Composable
fun BotonNormalv2() {
    Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
        containerColor = Color.Red
    )) {
        Text(text = "Boton color", fontSize = 30.sp)
    }
}

@Composable
fun BotonIcono() {
    IconButton(onClick = { /*TODO*/ }) {
        Icon(
            Icons.Filled.Home,
            contentDescription = "Icono Home",
            tint = Color.Red,
            modifier = Modifier.size(50.dp)
        )
    }
}

@Composable
fun FloatingButton() {
    FloatingActionButton(
        onClick = { /*TODO*/ },
        containerColor = Color.Blue,
        contentColor = Color.White
        ) {
        Icon(
            Icons.Filled.Add,
            contentDescription = null,
            modifier = Modifier.size(30.dp)
        )
    }
}