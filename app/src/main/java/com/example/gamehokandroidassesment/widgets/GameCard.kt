package com.example.gamehokandroidassesment.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gamehokandroidassesment.model.GameModel
import com.example.gamehokandroidassesment.ui.theme.HeadingColor

@Composable
fun GameCard(
    modifier: Modifier = Modifier,
    game: GameModel,
    oncClick: (Int) -> Unit
) {

    Column(
        modifier = Modifier.clickable { oncClick(game.id) },
        verticalArrangement = Arrangement.Center
    ){
        Image(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(width = 100.dp, height = 80.dp),
            painter = painterResource(id = game.image),
            contentDescription = "Game Image ${game.name}"
        )
        Text(
            text = game.name,
            fontSize = 12.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            color = HeadingColor
        )
    }

}