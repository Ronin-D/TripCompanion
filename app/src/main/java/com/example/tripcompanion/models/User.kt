package com.example.tripcompanion.models

@kotlinx.serialization.Serializable
data class User(
    val name:String,
    val password:String
)
