package com.example.gamehokandroidassesment.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gamehokandroidassesment.R
import com.example.gamehokandroidassesment.model.TournamentModel

@Composable
fun TournamentHeader(
    modifier: Modifier = Modifier,
    tournament: TournamentModel,
    timeLeftText: String,
    participantsText: String
) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = tournament.image),
            contentDescription = "${tournament.game.name} Tournament",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .height(185.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .align(Alignment.BottomCenter), // Align to bottom
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedText(text = timeLeftText)
            OutlinedTextWithImage(text = participantsText, image = R.drawable.group_icon)
        }
    }
}

@Composable
fun TournamentSubHeader(
    modifier: Modifier = Modifier,
    heading: String,
    subheading: String,
    subheadingImage: Int,
    image: Int
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

            Text(
                text = heading,
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 4.dp), // Adjust padding for better spacing
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ){

                Text(
                    text = subheading, // Use the renamed variable
                    fontSize = 14.sp, // Slightly smaller font size for the announcement
                    color = Color.White,
                    fontWeight = FontWeight.Light
                )
                Spacer(modifier = Modifier.size(4.dp))
                Image(
                    painter = painterResource(id = subheadingImage),
                    contentDescription = "money icon"
                )
            }

        }

        Image(
            painter = painterResource(id = image),
            contentDescription = "Game Controller", // More accurate description
            modifier = Modifier
                .size(40.dp) // Use a single size modifier for consistency
                .weight(0.2f)
        )



    }
}