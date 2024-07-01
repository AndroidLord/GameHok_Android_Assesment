package com.example.gamehokandroidassesment.util

import com.example.gamehokandroidassesment.R
import com.example.gamehokandroidassesment.model.GameModel
import com.example.gamehokandroidassesment.model.TournamentDetail
import com.example.gamehokandroidassesment.model.TournamentModel
import com.example.gamehokandroidassesment.model.UserModel
import java.util.Calendar
import java.util.Date

fun getBannerList(): List<Int> {

    val banners = listOf(
        R.drawable.banner1,
        R.drawable.tournament1
        // , R.drawable.banner2
    )
    return banners
}



fun getGameList(): List<GameModel> {
    val gameList = games
    return gameList
}

fun getTournamentList(): List<TournamentModel> {


    val calendar = Calendar.getInstance()


// Set specific date for registrationStart
    calendar.set(2024, Calendar.JANUARY, 24, 9, 0) // 24th Jan 2024, 09:00 AM
    val registrationStart: Date = calendar.time

// Set specific date for registrationEnd
    calendar.set(2024, Calendar.JULY, 24, 18, 0) // 24th Feb 2024, 06:00 PM
    val registrationEnd: Date = calendar.time

// Set specific date for tournamentStart
    calendar.set(2024, Calendar.AUGUST, 24, 10, 0) // 24th Mar 2024, 10:00 AM
    val tournamentStart: Date = calendar.time

    val prizes = listOf(
        Pair("1st Prize", 1000),
        Pair("2nd Prize", 500),
        Pair("3rd Prize", 200),
        Pair("4th Prize", 100),
        Pair("5th Prize", 100)
    )
    val roundAndSchedule = listOf(
        listOf("Qualifiers", "Single Elimination ", "Top 4 from every group"),
        listOf("Quarter Finals", "Single Elimination ", "Top 4 from every group"),
        listOf("Semi-Final", "Single Elimination ", "Top 4 of all"),
        listOf("Final", "Single Elimination ", "Winner")
    )

    val howToJoinMatch = listOf(
        "Have your game open already and on the latest version",
        "Once the match is configured you will receive an invite in-game to join the lobby.",
        "Join the match and wait for the game to start.",
        "When eliminated return to the match room page to be ready to join the next map in the round."
    )

    val tournamentList = listOf(
        TournamentModel(
            id = 1,
            game = games[0],
            image = R.drawable.tournament1,
            sponsor = "Red Bull",
            entry = "10",
            registrationStart = registrationStart,
            registrationEnd = registrationEnd,
            participants = 10,
            totalParticipants = 100,
            tournamentDetail = TournamentDetail(
                teamSize = "Solo",
                format = "Single Elimination",
                tournamentStart = tournamentStart,
                checkIn = "1 hour before",
                prize = prizes,
                RoundAndSchedule = roundAndSchedule,
                rules = howToJoinMatch
            )
        ), TournamentModel(
            id = 2,
            game = games[0],
            sponsor = "Red Bull",
            entry = "10",
            image = R.drawable.tournament1,
            registrationStart = registrationStart,
            registrationEnd = registrationEnd,
            participants = 10,
            totalParticipants = 100,
            tournamentDetail = TournamentDetail(
                teamSize = "Solo",
                format = "Single Elimination",
                tournamentStart = tournamentStart,
                checkIn = "1 hour before",
                prize = prizes,
                RoundAndSchedule = roundAndSchedule,
                rules = howToJoinMatch
            )
        ), TournamentModel(
            id = 3,
            game = games[0],
            sponsor = "Red Bull",
            entry = "10",
            image = R.drawable.tournament1,
            registrationStart = registrationStart,
            registrationEnd = registrationEnd,
            participants = 10,
            totalParticipants = 100,
            tournamentDetail = TournamentDetail(
                teamSize = "Solo",
                format = "Single Elimination",
                tournamentStart = tournamentStart,
                checkIn = "1 hour before",
                prize = prizes,
                RoundAndSchedule = roundAndSchedule,
                rules = howToJoinMatch
            )
        )
    )

    return tournamentList
}

fun getUserModelList(): List<UserModel> {
    val userModelList = listOf(
        UserModel(
            name = "Legend Gamer",
            image = R.drawable.user1,
            coin = 2456,
            followers = listOf(2, 3),
            following = listOf(2, 3),
            gamesFollowing = listOf(1, 2)
        ),
        UserModel(
            name = "Legend Gamer",
            image = R.drawable.user2,
            coin = 2456,
            followers = listOf(1, 3),
            following = listOf(1, 3),
            gamesFollowing = listOf(1, 2)
        ),
        UserModel(
            name = "Legend Gamer",
            image = R.drawable.user3,
            coin = 2456,
            followers = listOf(1, 2),
            following = listOf(1, 2),
            gamesFollowing = listOf(1, 2)
        )
    )
    return userModelList
}