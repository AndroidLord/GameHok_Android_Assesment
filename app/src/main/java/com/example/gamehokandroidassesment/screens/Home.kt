package com.example.gamehokandroidassesment.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gamehokandroidassesment.R
import com.example.gamehokandroidassesment.navigations.Routes
import com.example.gamehokandroidassesment.ui.theme.BaseColor
import com.example.gamehokandroidassesment.util.getBannerList
import com.example.gamehokandroidassesment.util.getGameList
import com.example.gamehokandroidassesment.util.getTournamentList
import com.example.gamehokandroidassesment.util.getUserModelList
import com.example.gamehokandroidassesment.widgets.ChipWidget
import com.example.gamehokandroidassesment.widgets.CreateYourTournament
import com.example.gamehokandroidassesment.widgets.DrawLine
import com.example.gamehokandroidassesment.widgets.ImageSliderWidget
import com.example.gamehokandroidassesment.widgets.ListGame
import com.example.gamehokandroidassesment.widgets.SectionWidget
import com.example.gamehokandroidassesment.widgets.TournamentList
import com.example.gamehokandroidassesment.widgets.UserRecommendation

@Composable
fun Home(navController: NavController) {
    val banners = getBannerList()
    val gameList = getGameList()
    val tournamentList = getTournamentList()
    val userRecommendations = getUserModelList()

    LazyColumn(
        modifier = Modifier
    ) {
        item {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.user),
                    contentDescription = "User",
                    modifier = Modifier
                        .size(40.dp)
                        .clickable {
                            // Handle click event
                        }
                )
                // Chip
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .background(BaseColor)
                        .align(Alignment.CenterVertically)
                        .padding(start = 8.dp, end = 8.dp)
                        .width(100.dp)
                ) {
                    ChipWidget(text = "2456", image = R.drawable.coin) {}
                    Icon(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        painter = painterResource(id = R.drawable.bell),
                        contentDescription = "Bell",
                        tint = Color.White
                    )
                }
            }

            ImageSliderWidget(banners)

            SectionWidget(heading = "Play Tournament By Games")
        }
        ListGame(game = gameList){
            // Handle click event
            Log.d("Args", "GameId: $it")
            navController.navigate(Routes.GameDetail.passGameId(it))
        }

        item {
            DrawLine()

            CreateYourTournament()
            SectionWidget(heading = "Compete in Battles")

            TournamentList(tournamentList = tournamentList){index->
                // Handle click event
//                Log.d("Home_1", "Home: $index")
                navController.navigate(Routes.TournamentDetail.passTournamentId(index))
            }

            SectionWidget(heading = "People to follow")


        }

        UserRecommendation(userRecommendations = userRecommendations)

    }
}
