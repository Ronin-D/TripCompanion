package com.example.tripcompanion.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tripcompanion.ui.trip_catalog.TripCatalogScreen
import com.example.tripcompanion.util.Graphs
import com.example.tripcompanion.util.Screens

@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Graphs.Auth.route ){
          authGraph(navController)
          bottomNavGraph(navController)
    }
}