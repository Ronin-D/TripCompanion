package com.example.tripcompanion.util

sealed class Screens(
    val route:String
){
    object SignUp:Screens(route = "sign_up")
    object SignIn:Screens(route = "sign_in")
}
