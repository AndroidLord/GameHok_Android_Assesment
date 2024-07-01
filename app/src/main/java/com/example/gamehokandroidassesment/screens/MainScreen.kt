package com.example.gamehokandroidassesment.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.gamehokandroidassesment.navigations.BottomNavItems
import com.example.gamehokandroidassesment.navigations.NavGraph
import com.example.gamehokandroidassesment.ui.theme.BaseColor



@Composable
fun MainScreen(navController: NavHostController) {

    Scaffold(
        bottomBar = {
            MyBottomNav(navController)
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BaseColor)
                .padding(innerPadding)
        ) {
            NavGraph(navController)
        }
    }
}

@Composable
private fun MyBottomNav(navController: NavController) {

    val selectedItem = remember { mutableStateOf(0) }

    val bottomBarScreens = listOf(
        BottomNavItems.Home,
        BottomNavItems.Community,
        BottomNavItems.Achievement,
        BottomNavItems.Detail
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val bottomBarDestination = bottomBarScreens.any{
        it.route == currentDestination?.route
    }

    if(!bottomBarDestination) return

    BottomAppBar(
        containerColor = Color.Black,
        contentColor = Color.White
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            bottomBarScreens.forEachIndexed() { index, item ->


                IconButton(onClick = {

                    selectedItem.value = index

                    navController.navigate(item.route){
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                }) {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title,
                        modifier = Modifier.size(24.dp),
                        tint = if (selectedItem.value == bottomBarScreens.indexOf(item)) Color.White else Color.Gray
                    )
                }
            }
        }
    }
}