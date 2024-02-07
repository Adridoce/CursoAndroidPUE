package com.cursoandroid.kotlinex.poo

open class User(val name: String) {
    // data
    var isLoggedIn: Boolean = false

    // comportamiento
    open fun login() {
        println("Usuario login (User)")
    }

    open fun logout() {
        println("Usiario logout (User)")
    }
}

class Student(name: String) : User(name) {

    override fun login() {
        super.login()
        println("Usuario login (Student)")
    }

    override fun logout() {
        //super.login()
        println("Usuario logout (Student)")
    }
}

fun main() {
    val estudiante1 = Student("Jose")
    println(estudiante1.isLoggedIn)
    estudiante1.login()
    estudiante1.isLoggedIn = true
    println(estudiante1.isLoggedIn)
    estudiante1.logout()
    estudiante1.isLoggedIn = false
    println(estudiante1.isLoggedIn)

    val user1 = User("Adri")
    user1.login()
    user1.logout()
}