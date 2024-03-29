package com.rja.rebajasapp.views

import android.widget.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rja.rebajasapp.components.Alert
import com.rja.rebajasapp.components.MainButton
import com.rja.rebajasapp.components.MainTextField
import com.rja.rebajasapp.components.SpaceH
import com.rja.rebajasapp.components.TwoCards
import com.rja.rebajasapp.viewModels.CalcularViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(paddingValues: PaddingValues, viewModel: CalcularViewModel) {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = { Text(text = "App Rebajas", color = Color.White) },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        )
    }) {
        ContentHomeView(paddingValues = it, viewModel = viewModel)
    }
}

@Composable
fun ContentHomeView(paddingValues: PaddingValues, viewModel: CalcularViewModel) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var precio by remember { mutableStateOf("") }
        var descuento by remember { mutableStateOf("") }
        var precioDescuento by remember { mutableStateOf(0.0) }
        var totalDescuento by remember { mutableStateOf(0.0) }
        var showAlerta by remember { mutableStateOf(false) }

        TwoCards(
            title1 = "Total",
            number1 = totalDescuento,
            title2 = "Descuento",
            number2 = precioDescuento
        )

        MainTextField(value = precio, onValueChange = { precio = it }, label = "Precio")
        SpaceH()
        MainTextField(value = descuento, onValueChange = { descuento = it }, label = "Descuento %")
        SpaceH(10.dp)
        MainButton(text = "Generar descuento") {

            val result = viewModel.calcular(precio, descuento)
            showAlerta = result.second.second
            if (!showAlerta) {
                precioDescuento = result.first
                totalDescuento = result.second.first
            }
        }
        SpaceH()
        MainButton(text = "Limpiar campos") {
            precio = ""
            descuento = ""
            precioDescuento = 0.0
            totalDescuento = 0.0
        }

        if (showAlerta) {
            Alert(
                title = "Aviso",
                message = "Informar del precio y/o descuento",
                confirmText = "Aceptar",
                onConfirmClick = { showAlerta = false }) {

            }
        }
    }
}