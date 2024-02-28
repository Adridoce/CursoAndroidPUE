package com.rja.rebajasapp.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rja.rebajasapp.components.MainButton
import com.rja.rebajasapp.components.MainTextField
import com.rja.rebajasapp.components.TwoCards
import com.rja.rebajasapp.viewModels.CalcularViewModel


@Composable
fun HomeView(paddingValues: PaddingValues,  viewModel: CalcularViewModel) {

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var precio by remember { mutableStateOf("") }
        var descuento by remember { mutableStateOf("") }
        var precioDescuento by remember { mutableStateOf(0.0)}
        var totalDescuento by remember { mutableStateOf(0.0)}
        var showAlerta by remember { mutableStateOf(false)}

        TwoCards(
            title1 = "Total",
            number1 = totalDescuento,
            title2 = "Descuento" ,
            number2 =  precioDescuento )

        MainTextField(value = precio, onValueChange = { precio = it} , label = "Precio")
        MainTextField(value = descuento, onValueChange = { descuento = it} , label = "Descuento %")
        MainButton(
            text = "Generar descuento") {

            val result = viewModel.calcular(precio, descuento)
            precioDescuento = result.first
            totalDescuento = result.second.first
        }

    }

}