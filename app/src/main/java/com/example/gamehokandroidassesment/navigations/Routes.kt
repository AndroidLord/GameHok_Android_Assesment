package com.example.gamehokandroidassesment.navigations

sealed class Routes(val route: String) {


    // Bottom App Bar Routes
    object Home : Routes("home")
    object Detail : Routes("detail")
    object Achievement : Routes("achievement")
    object Community : Routes("community")

    // Screen Routes

    // TournamentDetail Screen Routes
    object TournamentDetail : Routes("tournamentDetail/{tournamentId}"){
        fun passTournamentId(tournamentId: Int): String {
            return "tournamentDetail/$tournamentId"
        }
    }

    // GameDetail Screen Routes
    object GameDetail : Routes("gameDetail/{gameId}"){
        fun passGameId(gameId: Int): String {
            return "gameDetail/$gameId"
        }
    }
}