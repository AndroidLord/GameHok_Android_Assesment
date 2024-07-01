package com.example.gamehokandroidassesment.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gamehokandroidassesment.R
import com.example.gamehokandroidassesment.model.TournamentModel
import com.example.gamehokandroidassesment.ui.theme.BaseColor
import com.example.gamehokandroidassesment.ui.theme.BrightGreen
import com.example.gamehokandroidassesment.util.monthDayFormat
import com.example.gamehokandroidassesment.util.monthDayYearFormat


@Composable
fun TournamentList(
    modifier: Modifier = Modifier,
    tournamentList: List<TournamentModel>,
    onClick: (Int) -> Unit
) {

    LazyRow(
        modifier = modifier.padding(8.dp)
    ) {

        items(tournamentList.size) { index ->
            val tournament = tournamentList[index]
            val tournamentHeading =
                "${tournament.game.name} Tournament" + if (tournament.sponsor!!.isNotEmpty()) " By ${tournament.sponsor}" else ""
            val time =
                monthDayFormat(tournament.registrationStart) + " - " + monthDayYearFormat(tournament.registrationEnd)
            val paricipants = "${tournament.participants}/${tournament.totalParticipants}"

            TournamentCard(tournament, tournamentHeading, time, paricipants, onClick)

        }

    }


}

@Composable
private fun TournamentCard(
    tournament: TournamentModel,
    tournamentHeading: String,
    time: String, participants: String,
    onClick: (Int) -> Unit
) {
    OutlinedCard(
        modifier = Modifier
            .width(250.dp)
            .padding(8.dp)
            .clickable { onClick(tournament.id) }
        ,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(
            contentColor = BrightGreen,
            containerColor = BaseColor
        )
    ) {
        Box(modifier = Modifier) {

            Image(
                painter = painterResource(id = tournament.image),
                contentDescription = "${tournament.game.name} Tournament",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedCard(
                    colors = CardDefaults.cardColors(
                        contentColor = BrightGreen,
                        containerColor = Color.Black.copy(alpha = 0.9f)
                    ),
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(12.dp))

                ) {
                    Text(
                        text = "Registration Open",
                        fontWeight = FontWeight.Bold,
                        fontSize = 10.sp,
                        color = Color.White,
                        modifier = Modifier.padding(start = 4.dp, end = 4.dp)
                    )
                }


                OutlinedCard(
                    colors = CardDefaults.cardColors(
                        contentColor = BrightGreen,
                        containerColor = Color.Black.copy(alpha = 0.9f)
                    ),
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(12.dp))

                ) {

                    Row(
                        modifier = Modifier.padding(start = 4.dp, end = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            painter = painterResource(id = R.drawable.baseline_diamond_24),
                            contentDescription = "calendar",
                            modifier = Modifier.size(11.dp),
                            tint = BrightGreen
                        )
                        Text(
                            text = "100000 ",
                            fontWeight = FontWeight.Bold,
                            fontSize = 10.sp,
                            color = Color.White,
                        )
                        Image(
                            painter = painterResource(id = R.drawable.coin),
                            contentDescription = "coin",
                            modifier = Modifier.size(11.dp),
                        )
                    }
                }
            }
        }



        Column(modifier = Modifier.padding(8.dp)) { // Added padding for better visual spacing

            Spacer(modifier = Modifier.height(8.dp)) // Added spacer for better visual separation
            Text(
                text = tournamentHeading,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = Color.White,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.calendar_icon),
                    contentDescription = "calendar",
                    modifier = Modifier.size(16.dp),
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = time, color = Color.White, fontSize = 12.sp)
            }
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Entry - ${tournament.entry}",
                        color = Color.White,
                        fontSize = 12.sp
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Image(
                        painter = painterResource(id = R.drawable.coin),
                        contentDescription = "coin", // Fixed content description
                        modifier = Modifier.size(16.dp),
                    )
                }
                Text(text = participants, color = Color.White, fontSize = 12.sp)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "See Tournament Details",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                ) // Fixed typo
                Icon(
                    painter = painterResource(id = R.drawable.right_arrow_icon),
                    contentDescription = "More Tournament Details Icon",
                    tint = BrightGreen,
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    }
}
