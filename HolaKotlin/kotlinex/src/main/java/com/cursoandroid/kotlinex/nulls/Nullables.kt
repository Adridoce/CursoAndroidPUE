package com.cursoandroid.kotlinex.nulls

data class Movie(
    val id: Int?,
    val name: String
)

fun main() {
    val m1 = Movie(null, "ET")

    var nameNullable: String? = null

    println("Valor es ${nameNullable?.length}") // Safe operator
}