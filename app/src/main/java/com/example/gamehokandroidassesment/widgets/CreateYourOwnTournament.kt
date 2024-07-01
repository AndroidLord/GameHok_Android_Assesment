package com.example.gamehokandroidassesment.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gamehokandroidassesment.R
import com.example.gamehokandroidassesment.ui.theme.CreateTournamentColor
import com.example.gamehokandroidassesment.util.Constants.TournamentAnnouncement


@Composable
fun CreateYourTournament(modifier: Modifier = Modifier) {
    // Use a more descriptive name for the color
    val createTournamentCardColor = CreateTournamentColor

    Card(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = createTournamentCardColor
        )
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically // Align items vertically
        ) {
            Column(
                modifier = Modifier.weight(0.8f)
            ) {
                // Use a more descriptive name for the announcement text
                val tournamentAnnouncement = TournamentAnnouncement

                Text(
                    text = "Create Your own Tournament",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 4.dp), // Adjust padding for better spacing
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = tournamentAnnouncement, // Use the renamed variable
                    fontSize = 14.sp, // Slightly smaller font size for the announcement
                    color = Color.Black,
                    fontWeight = FontWeight.Light
                )
            }

            Image(
                painter = painterResource(id = R.drawable.game_controller),
                contentDescription = "Game Controller", // More accurate description
                modifier = Modifier
                    .size(54.dp) // Use a single size modifier for consistency
                    .weight(0.2f)
            )

        }
    }
}

