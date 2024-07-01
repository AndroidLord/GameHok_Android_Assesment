package com.example.gamehokandroidassesment.util

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode

object Constants {


    const val TournamentAnnouncement = "Host and manage your own tournaments and play with your friends"

    val c1 = Color(24, 41, 32)
    val c2 = Color(77, 90, 83)

    val gradient = Brush.linearGradient(
        colors = listOf(c1, c2),
        start = Offset(0f, 0f),
        end = Offset(1000f, 0f),
        tileMode = TileMode.Repeated
    )

    val organizationDetail = "This is the in house organiser of this platform you can follow our page on this platform for regular updates"

    val contactNo = "9890987754"
    val whatsappNo = "9890987754"
    val gmail = "Support@gamehok.com"



}