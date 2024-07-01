package com.example.gamehokandroidassesment.navigations

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.gamehokandroidassesment.R

sealed class BottomNavItems(
    val route: String,
    val title: String,
    val icon: Int
){

    object Home : BottomNavItems(
        route = Routes.Home.route,
        title = "Home",
        icon = R.drawable.home_icon
    )

    object Community : BottomNavItems(
        route = Routes.Community.route,
        title = "Community",
        icon = R.drawable.cup_icon
    )

    object Achievement : BottomNavItems(
        route = Routes.Achievement.route,
        title = "Achievement",
        icon = R.drawable.group_icon
    )

    object Detail : BottomNavItems(
        icon = R.drawable.stream_icon,
        route = Routes.Detail.route,
        title = "Detail"
    )
}
