package com.cursoandroid.kotlinex.poo

class Item() {
    var name: String = ""
    var price: Double = 0.0
        get(){
            println("Dentro del getter")
            return field
        }
        set(value) {
            if (value >= 0.0 ) {
                println("Dentro del setter")
                field = value
            } else {
                throw IllegalArgumentException("No son validos valores negativos")
            }
        }

    constructor(_name: String) : this() {
        name = _name
    }
}

fun main() {
    val item1 = Item("Samsung")
    println("El item se llama ${item1.name}")
    item1.name = "Samsung Galaxy"

    // Esto daria error por la condicion que hemos puesto en el setter
    item1.price = -10.6
    println(item1.price)
}