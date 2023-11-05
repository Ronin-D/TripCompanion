package com.example.tripcompanion.ui.bottom_navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.example.tripcompanion.util.Screens

@Composable
fun BottomNavMenu(navController: NavController) {
    val items = listOf(
        BottomNavMenuItem.TripCatalogScreen,
        BottomNavMenuItem.AddTripScreen,
        BottomNavMenuItem.ProfileScreen,
    )
    val otherScreens = listOf(
        Screens.SignUp.route,
        Screens.SignIn.route
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val menuHeight = 52.dp
    val visibility = remember{
        mutableStateOf(0.dp)
    }
    BottomNavigation(
        modifier = Modifier
            .fillMaxWidth()
            .height(visibility.value),
        backgroundColor = DarkBlue,
        contentColor = Color.White
    ){
        if (otherScreens.contains(currentDestination?.route)){
           visibility.value = 0.dp
       }
        else{
            visibility.value = menuHeight
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

}