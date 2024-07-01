package com.example.gamehokandroidassesment.model

data class UserModel(
    val name: String,
    val image: Int,
    val coin: Int=2456,
    val followers: List<Int>,
    val following: List<Int>,
    val gamesFollowing: List<Int>

)
