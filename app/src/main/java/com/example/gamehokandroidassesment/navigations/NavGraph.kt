package com.example.gamehokandroidassesment.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.gamehokandroidassesment.screens.Achievement
import com.example.gamehokandroidassesment.screens.Community
import com.example.gamehokandroidassesment.screens.Detail
import com.example.gamehokandroidassesment.screens.GameDetailScreen
import com.example.gamehokandroidassesment.screens.Home
import com.example.gamehokandroidassesment.screens.TournamentDetailScreen


@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Routes.Home.route
    ) {

        composable(
            route = Routes.Home.route
        ) {
            Home(navController)
        }
        composable(
            route = Routes.Detail.route
        ) {
            Detail(navController)
        }
        composable(
            route = Routes.Achievement.route
        ) {
            Achievement(navController)
        }
        composable(
            route = Routes.Community.route
        ) {
            Community(navController)
        }

        // TournamentDetail Screen
        composable(
            route = Routes.TournamentDetail.route
        ) { navBackStackEntry ->

            val tournamentId = navBackStackEntry.arguments?.getString("tournamentId")

            tournamentId?.let {
                TournamentDetailScreen(
                    navController,
                    tournamentId = it.toInt()
                )
            }

        }

        // GameDetail Screen
        composable(
            route = Routes.GameDetail.route
        ) { navBackStackEntry ->

            val gameId = navBackStackEntry.arguments?.getString("gameId")

            gameId?.let {
                GameDetailScreen(
                    navController,
                    gameId = it.toInt()
                )
            }

        }


    }

}