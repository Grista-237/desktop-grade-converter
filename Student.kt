package model

data class Student(
    val name: String,
    val id: String? = null,
    val subjects: Map<String, Double>
)
