package com.example.gamehokandroidassesment.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gamehokandroidassesment.model.GameRequirements
import com.example.gamehokandroidassesment.util.getGameList
import com.example.gamehokandroidassesment.widgets.GameDetailHeader

import com.example.gamehokandroidassesment.widgets.GameDetailSubHeader
import com.example.gamehokandroidassesment.widgets.GameTabs

@Composable
fun GameDetailScreen(
    navController: NavController,
    gameId: Int
) {

    // validate gameId
    val game = getGameList().find { it.id == gameId } ?: run {
        navController.popBackStack()
        return
    }

    Column {
        GameDetailHeader(game = game, ageGroup = game.ageGroup.toInt())
        GameDetailSubHeader(gameName = game.name, gameDescription = game.description,genre=game.genre)
        Text(
            text = "Game Details",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(16.dp)
        )
        GameTabs(game = game,navController = navController)


    }

}