package com.example.gamehokandroidassesment.model

import java.util.Date

data class TournamentModel(
    val id: Int,
    val image: Int,
    val game: GameModel,
    val sponsor: String?,
    val entry: String,
    val registrationStart: Date,
    val registrationEnd: Date,
    var participants: Int,
    val totalParticipants: Int,
    val tournamentDetail: TournamentDetail,
)

data class TournamentDetail(
    val teamSize: String,
    val format: String,
    val tournamentStart: Date,
    val checkIn: String,
    val prize: List<Pair<String,Int>>,
    val RoundAndSchedule: List<List<String>>,
    val rules: List<String>
)
