package com.example.gamehokandroidassesment.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gamehokandroidassesment.R
import com.example.gamehokandroidassesment.ui.theme.BaseColor
import com.example.gamehokandroidassesment.util.getTournamentList
import com.example.gamehokandroidassesment.util.timeLeft
import com.example.gamehokandroidassesment.widgets.TournamentHeader
import com.example.gamehokandroidassesment.widgets.TournamentSubHeader
import com.example.gamehokandroidassesment.widgets.TournamentTabs

@Composable
fun TournamentDetailScreen(
    navController: NavController,
    tournamentId: Int
) {
    if (tournamentId == 0) {
        navController.popBackStack()
        return
    }
    val tournament = getTournamentList().find { it.id == tournamentId }
        ?: run {
            navController.popBackStack()
            return
        }
    val timeLeftText = timeLeft(tournament.registrationEnd)
    val participantsText = "${tournament.participants}/${tournament.totalParticipants}"



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BaseColor)
    ) {

        TournamentHeader(
            tournament = tournament,
            timeLeftText = timeLeftText,
            participantsText = participantsText
        )

        TournamentSubHeader(
            heading = "${tournament.game.name} Tournament",
            subheading = "Entry - ${tournament.entry}",
            subheadingImage = R.drawable.coin,
            image = R.drawable.game_controller2
        )

        TournamentTabs(tournament = tournament, navController = navController)

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(1, 183, 82)
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Join Tournament",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center, // Align text to center
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }

    }


}

