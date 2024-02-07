package com.cursoandroid.kotlinex

open class SuperButton {
    open fun disable() {
        println("Boton deshabilitado")
    }
    open fun animate() {
        println("Animando boton")
    }
}

class PlayButton : SuperButton() {

    override fun disable() {
        println("Boton play deshabilitado")
    }

    override fun animate() {
        println("Boton play animado")
    }
}

fun main() {
    println("Hola mundo")

    val playButton = PlayButton()

    playButton.disable()
    playButton.animate()
}