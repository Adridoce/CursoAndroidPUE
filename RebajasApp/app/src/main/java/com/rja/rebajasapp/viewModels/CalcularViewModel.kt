package com.rja.rebajasapp.viewModels

import androidx.lifecycle.ViewModel

class CalcularViewModel: ViewModel() {

    fun calcular(precio: String, descuento: String): Pair<Double, Pair<Double, Boolean>> {
        var precioDescuento = 0.0
        var totalDescuento = 0.0
        var showAlerta = false

        if(precio != "" && descuento != "") {
            //proceso
            precioDescuento = calcularPrecio(precio.toDouble(), descuento.toDouble())
            totalDescuento = calcularDescuento(precio.toDouble(), descuento.toDouble())
        } else {
            showAlerta = true
        }

        return Pair(precioDescuento, Pair(totalDescuento, showAlerta))
    }

    private fun calcularPrecio(precio: Double, descuento: Double): Double {
        val res = precio - calcularDescuento(precio, descuento)
        return kotlin.math.round(res * 100) / 100
    }

    private fun calcularDescuento(precio: Double, descuento: Double): Double {
        val res = precio * (1 - descuento/100)
        return kotlin.math.round(res * 100) / 100

    }





}