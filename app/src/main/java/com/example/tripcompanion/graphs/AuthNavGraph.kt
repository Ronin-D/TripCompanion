package com.example.tripcompanion.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.tripcompanion.ui.auth.SignInScreen
import com.example.tripcompanion.ui.auth.SignUpScreen
import com.example.tripcompanion.util.BottomNavMenuItem
import com.example.tripcompanion.util.Screens

fun NavGraphBuilder.authGraph(navController: NavController){
    navigation(
        route = "auth",
        startDestination = Screens.SignIn.route
    ){
        composable(Screens.SignIn.route){
            SignInScreen(
                onNavigateToMainScreen = {
                    navController.navigate(BottomNavMenuItem.TripCatalogScreen.route){
                        popUpTo(navController.graph.findStartDestination().id){
                            inclusive=true
                        }
                    }
                },
                onNavigateToSignUp = {
                    navController.navigate(Screens.SignUp.route)
                }
            )
        }
        composable(Screens.SignUp.route){
            SignUpScreen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}