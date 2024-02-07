package com.cursoandroid.kotlinex.functions

import com.cursoandroid.kotlinex.poo.Course
import com.cursoandroid.kotlinex.poo.Category

fun main() {
    //let
    exploreLet()

    //apply
    exploreApply()
}

fun exploreApply() {
    val category = ""
    val course = Course(
        1,
        "Java",
        "Romero"
    ).apply {
        this.category = Category.BUSINESS
    }

    println(course.category)
}

fun exploreLet() {
    val numbers = mutableListOf(1, 2, 3, 4, 5)
    val result = numbers.map { it * 2 }.filter { it > 5 }.let { // let solo se ejecuta si no es nulo
        println(it)
        it.sum()
    }

    println(result)

    var name: String? = null
    name = "Jose"
    val r1 = name?.let {
        println(it)
        it.uppercase()
    }

    println(r1)
}

