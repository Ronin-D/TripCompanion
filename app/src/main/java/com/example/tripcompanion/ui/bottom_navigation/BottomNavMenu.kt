package com.example.tripcompanion.ui.bottom_navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.tripcompanion.ui.theme.DarkBlue
import com.example.tripcompanion.util.BottomNavMenuItem

@Composable
fun BottomNavMenu(navController: NavController) {
    val items = listOf(
        BottomNavMenuItem.TripCatalogScreen,
        BottomNavMenuItem.AddTripScreen,
        BottomNavMenuItem.ProfileScreen,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    BottomNavigation(
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp),
        backgroundColor = DarkBlue,
        contentColor = Color.White
    ){
        items.forEach{screen->
            val isSelected =  currentDestination?.hierarchy?.any { it.route==screen.route }==true
            BottomNavigationItem(
                selected = isSelected,
                icon = {
                    Icon(
                        painter = rememberVectorPainter(image =
                        if (isSelected){
                            screen.selectedItemResource
                        }
                        else{
                            screen.unselectedItemResource
                        }),
                        contentDescription = "${screen.route} icon"
                    )},
                label = {
                    Text(text = screen.route, color = Color.White)
                },
                onClick = {
                    navController.navigate(screen.route){
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }

}