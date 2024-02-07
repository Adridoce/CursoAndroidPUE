package com.cursoandroid.kotlinex.collections

fun doblar(x: Int): Int {
    return x + x
}

// HOF -> High Order Functions (Reciben una funcion)
fun calculate(x: Int, y: Int, op: (x: Int, y: Int) -> Int): Int {
    return op(x, y)
}

fun main() {

    // funcion lambda -> funcion anonima, siempre entre {}
    val doblarLambda = { z: Int -> z + z }

    val resultado = doblarLambda(3)
    println("$resultado")

    val multilineaLambda = { x: Int, y: Int ->
        println("x es es $x e y es $y")
        x * y
        //1           // El return de las funciones lambda siempre es la ultima linea

        val resultadoCalculate = calculate(12, 3, {a, b -> a + b})
        println(resultadoCalculate)

        val resultadoCalculate2 = calculate(12, 3, {a, b -> a * b})
        println(resultadoCalculate2)

        val resultadoCalculate3 = calculate(12, 3) {a, b -> a - b} // Operacion ultimo parametro y fuera de los parentesis
        println(resultadoCalculate3)
    }

    val resultado2 = multilineaLambda(2, 4)
    println(resultado2)
}