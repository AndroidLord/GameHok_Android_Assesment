package com.example.gamehokandroidassesment.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gamehokandroidassesment.model.GameModel
import com.example.gamehokandroidassesment.model.TournamentModel
import com.example.gamehokandroidassesment.navigations.Routes
import com.example.gamehokandroidassesment.ui.theme.BaseColor
import com.example.gamehokandroidassesment.ui.theme.TextGray
import com.example.gamehokandroidassesment.util.Constants.gradient
import com.example.gamehokandroidassesment.util.GameAnnotatedText
import com.example.gamehokandroidassesment.util.getTournamentList


@Composable
fun GameOverviewTab(game: GameModel, navController: NavController) {

    val pubgTournaments: List<TournamentModel> = getTournamentList().filter { it.game.id == game.id }

    LazyColumn {
        item {
            GameDetailInfo(game = game)
            Text(text = "Game Requirements", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.ExtraBold, modifier = Modifier.padding(16.dp))
            GameDetailRequirements(game = game)
            Text(text = "${game.name} Tournaments", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.ExtraBold, modifier = Modifier.padding(16.dp))
            if(pubgTournaments.isEmpty()) {
                Text(text = "🥲 No Tournaments Available", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Medium, modifier = Modifier.padding(16.dp))
            }
            TournamentList(tournamentList = pubgTournaments) {
                navController.navigate(Routes.TournamentDetail.passTournamentId(it))
            }
        }
    }

}

@Composable
private fun GameDetailInfo(game: GameModel) {
    val rating = game.rating

    GameAnnotatedText(
        boldText = "• Rating: ",
        regularText = "${rating}/5",
        textColor = Color.White,
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp)
    )
    GameAnnotatedText(
        boldText = "• Release Date: ",
        regularText = "${game.releaseDate}",
        textColor = Color.White,
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp)
    )
    GameAnnotatedText(
        boldText = "• Age Group: ",
        regularText = "${game.ageGroup}+",
        textColor = Color.White,
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp)
    )
    GameAnnotatedText(
        boldText = "• Downloads: ",
        regularText = "10M+",
        textColor = Color.White,
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp)
    )
    GameAnnotatedText(
        boldText = "• Developer: ",
        regularText = "${game.developer}",
        textColor = Color.White,
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp)
    )
    GameAnnotatedText(
        boldText = "• Publisher: ",
        regularText = "${game.publisher}",
        textColor = Color.White,
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp)
    )
}

@Composable
fun GameDetailRequirements(game: GameModel) {

    OutlinedCard(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = BaseColor
        )
    ) {
        GameDetailRequirementRow(
            c1 = "Requirements", c2 = "Min.", c3 = "Rec.",
            color = Color.White,
            modifier = Modifier.background(brush = gradient)
            )
        HorizontalDivider()
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {

            val minReq = game.minRequirements
            val recReq = game.recRequirements

            GameDetailRequirementRow(c1 = "OS", c2 = minReq.os, c3 = recReq.os)
            GameDetailRequirementRow(c1 = "Processor", c2 = minReq.processor, c3 = recReq.processor)
            GameDetailRequirementRow(c1 = "Memory", c2 = minReq.memory, c3 = recReq.memory)
            GameDetailRequirementRow(c1 = "Graphics", c2 = minReq.graphics, c3 = recReq.graphics)
            GameDetailRequirementRow(c1 = "Storage", c2 = minReq.storage, c3 = recReq.storage)

        }
    }
}

@Composable
fun GameDetailRequirementRow(
    modifier: Modifier = Modifier,
    c1: String,
    c2: String,
    c3: String,
    color: Color = TextGray
) {

    Row(
        modifier = modifier.padding(8.dp)

    ) {
        Text(
            text = c1,
            color = color,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.weight(1f).padding(1.dp)
        )
        Text(
            text = c2,
            color = color,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.weight(1f).padding(1.dp)
        )
        Text(
            text = c3,
            color = color,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.weight(1f).padding(1.dp)
        )
    }


}



