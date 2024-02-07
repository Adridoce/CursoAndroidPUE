package com.cursoandroid.kotlinex.collections

fun main() {
    // Listas
    val names = listOf("Juan", "Maria", "Pedro") //Inmutable
    val mutableNames = mutableListOf("Juan", "Maria", "Pedro") //Mutable

    mutableNames.add("Javier")
    println("$mutableNames")

    // Conjuntos
    val set = setOf("Juan", "Maria", "Pedro")
    val mutableSet = mutableSetOf("Juan", "Maria", "Pedro")

    mutableSet.add("Raquel")
    println("$mutableSet")

    // Diccionarios
    val mapNames = mapOf("1" to "a", "2" to "b", "3" to "c")
    val mutableMap = mutableMapOf("1" to "a", "2" to "b", "3" to "c")
    println(mutableMap)
}