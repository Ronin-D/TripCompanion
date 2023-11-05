package com.example.tripcompanion.util

sealed class Graphs(val route:String){
    object Auth:Graphs(route = "auth")
    object BottomNav:Graphs(route = "bottom_nav")
}
