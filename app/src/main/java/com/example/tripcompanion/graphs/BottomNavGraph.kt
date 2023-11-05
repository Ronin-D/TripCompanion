package com.example.tripcompanion.graphs

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.tripcompanion.ui.trip_catalog.TripCatalogScreen
import com.example.tripcompanion.util.BottomNavMenuItem
import com.example.tripcompanion.util.Graphs

fun NavGraphBuilder.bottomNavGraph(navController: NavController) {
   navigation(
       startDestination = BottomNavMenuItem.TripCatalogScreen.route,
       route=Graphs.BottomNav.route
   ){
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