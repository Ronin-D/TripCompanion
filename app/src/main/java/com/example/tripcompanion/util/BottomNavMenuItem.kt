package com.example.tripcompanion.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
sealed class BottomNavMenuItem(
    val route:String,
    val selectedItemResource:ImageVector,
    val unselectedItemResource:ImageVector,
    var hasNews:Boolean,
    var messagesCnt:Int?
){
    object TripCatalogScreen:BottomNavMenuItem(
        route = "trips",
        selectedItemResource = Icons.Filled.Home,
        unselectedItemResource = Icons.Outlined.Home,
        false,
        null
    )
    object ProfileScreen:BottomNavMenuItem(
        route = "profile",
        selectedItemResource = Icons.Filled.Person,
        unselectedItemResource = Icons.Outlined.Person,
        false,
        null
    )
    object AddTripScreen:BottomNavMenuItem(
        route = "add trip",
        selectedItemResource = Icons.Filled.AddCircle,
        unselectedItemResource = Icons.Outlined.AddCircle,
        false,
        null
    )
}