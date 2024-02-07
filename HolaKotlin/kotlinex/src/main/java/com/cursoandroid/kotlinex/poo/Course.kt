package com.cursoandroid.kotlinex.poo

data class Course(
    val id: Int,
    val name: String,
    val author: String,
    var category: Category = Category.DEVELOPMENT)

enum class Category {
    DEVELOPMENT,
    BUSINESS,
    DESIGN,
    MARKETING
}

fun main() {

    val course = Course(1, "Programacion reactiva Kotlin", "Juan Lopez")
    val course2 = Course(2, "Programacion POO Kotlin", "Juan Lopez")
    val course3 = course2.copy(3, "Maria Fernandez")

    val marketingCourse = Course(
        4,
        "Instagram ads",
        "Maria Lopez",
        Category.MARKETING)

    println(course)
    println(course2)
    println(course3)
    println(marketingCourse)
}
