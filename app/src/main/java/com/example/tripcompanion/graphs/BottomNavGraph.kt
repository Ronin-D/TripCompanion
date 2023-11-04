package com.example.tripcompanion.graphs

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tripcompanion.ui.trip_catalog.TripCatalogScreen
import com.example.tripcompanion.util.BottomNavMenuItem

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavMenuItem.TripCatalogScreen.route,){
        composable(route = BottomNavMenuItem.TripCatalogScreen.route){
            TripCatalogScreen()
        }
        composable(route = BottomNavMenuItem.AddTripScreen.route){
            Text(text = BottomNavMenuItem.AddTripScreen.route)
        }
        composable(route = BottomNavMenuItem.ProfileScreen.route){
            Text(text = BottomNavMenuItem.ProfileScreen.route)
        }
    }
}