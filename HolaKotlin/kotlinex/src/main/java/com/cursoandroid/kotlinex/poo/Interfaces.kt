package com.cursoandroid.kotlinex.poo

// Interfaz -> contrato

interface CourseRepository {
    val isCoursePersisted: Boolean
    fun getById(id: Int): Course

    fun save(course: Course) : Int {
        println("Course: $course")
        return course.id
    }
}
