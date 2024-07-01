package com.example.gamehokandroidassesment.model

data class GameModel(
    val id: Int,
    val name: String,
    val image: Int,
    val description: String,
    val rating: Float,

    val comments: List<GameComments>,
    val minRequirements: GameRequirements,
    val recRequirements: GameRequirements,
    val genre: List<String>,

    val developer: String,
    val publisher: String,
    val releaseDate: String,
    val ageGroup: String,

)
data class GameRequirements(
    val id: Int,
    val gameId: Int,
    val os: String,
    val processor: String,
    val memory: String,
    val graphics: String,
    val storage: String
)
data class GameComments(
    val id: Int,
    val gameId: Int,
    val comment: String,
    val user: String,
    val date: String
)

