package com.example.taller1.model
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class User(
    val id: Int,
    @SerialName("firstName") val nombre: String,
    @SerialName(value = "lastName") val apellido: String,
    @SerialName("email") val mail: String,
    @SerialName("phone") val celular: String,
    val company: Company,
    @SerialName("age") val edad: Int,
    @SerialName("gender") val genero: String,
    @SerialName("height") val altura: Float,
    @SerialName("weight") val peso: Float,
    @SerialName("university") val universidad: String,
)
