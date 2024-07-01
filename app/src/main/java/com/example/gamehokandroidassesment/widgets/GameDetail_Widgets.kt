package com.example.gamehokandroidassesment.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gamehokandroidassesment.R
import com.example.gamehokandroidassesment.model.GameComments
import com.example.gamehokandroidassesment.model.GameModel
import com.example.gamehokandroidassesment.model.TournamentModel
import com.example.gamehokandroidassesment.navigations.Routes
import com.example.gamehokandroidassesment.ui.theme.BaseColor
import com.example.gamehokandroidassesment.ui.theme.TextGray
import com.example.gamehokandroidassesment.util.GameDetailReview
import com.example.gamehokandroidassesment.util.GameOutlinedAnnotatedText
import com.example.gamehokandroidassesment.util.GameOutlinedText
import com.example.gamehokandroidassesment.util.getTournamentList
import com.example.gamehokandroidassesment.util.getUserModelList


@Composable
fun GameDetailHeader(
    modifier: Modifier = Modifier,
    game: GameModel,
    ageGroup: Int
) {

    val interested = getUserModelList().filter { it.gamesFollowing.contains(game.id) }.size

    Box(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = game.image),
            contentDescription = game.name.uppercase(),
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
            GameOutlinedAnnotatedText(
                regularText = "Age Group: ",
                boldText = "${ageGroup}+",
                fontSize = 10.sp,
                fontWeight = if (ageGroup >= 16) FontWeight.Bold else FontWeight.Normal
            )
            OutlinedTextWithImage(text = "${interested}+ Following", image = R.drawable.group_icon)
        }
    }

}

@Composable
fun GameDetailSubHeader(
    modifier: Modifier = Modifier,
    gameName: String,
    gameDescription: String,
    genre: List<String>,
) {

    val rows = if (genre.size < 6) 1 else 2

    Column {
        Text(
            text = gameName.uppercase(),
            fontSize = 20.sp,
            color = Color.White,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp)
        )
        Text(
            text = gameDescription,
            fontSize = 14.sp,
            color = TextGray,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
        )
        LazyHorizontalGrid(
            rows = GridCells.Fixed(rows),
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .height(30.dp * rows)
        ) {
            items(genre.size) { index ->
                GameOutlinedText(
                    modifier = Modifier.padding(4.dp),
                    text = genre[index]
                )
            }
        }

    }

}

@Composable
fun GameTabs(
    modifier: Modifier = Modifier,
    game: GameModel,
    navController: NavController
) {
    val tabList = listOf("Overview", "Events", "Review", "Reqs")
    var selectedTabIndex by remember { mutableStateOf(0) }

    Column {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = BaseColor,
            contentColor = Color.White,
            indicator = { tabPositions ->
                // change the color of scroll indicator
                TabRowDefaults.SecondaryIndicator(
                    Modifier
                        .tabIndicatorOffset(tabPositions[selectedTabIndex])
                        .background(Color.White)
                        .padding(horizontal = tabPositions[selectedTabIndex].width)
                        .height(2.dp)
                )
            },
        ) {
            tabList.forEachIndexed { index, title ->
                Tab(
                    text = {
                        Text(
                            title,
                            fontSize = 14.sp,
                            color = if (selectedTabIndex == index) Color.White else Color.LightGray
                        )
                    },
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index }
                )
            }
        }

        when (selectedTabIndex) {
            0 -> GameOverviewTab(game, navController)
            1 -> GameTournamentTab(game,navController)
            2 -> GameReviewTab(game.comments)
            3 -> GameRequirementsTab(game)
        }
    }


}

@Composable
fun GameTournamentTab(game: GameModel, navController: NavController) {
    val allTournaments = getTournamentList()
    val pubgTournaments: List<TournamentModel> = allTournaments.filter { it.game.id == game.id }
    LazyColumn {
        item{
            // Game Related Tournaments
            Text(text = "${game.name} Tournaments", color = Color.White, fontSize = 20.sp, modifier = Modifier.padding(16.dp))
            TournamentList(tournamentList = pubgTournaments) {
                navController.navigate(Routes.TournamentDetail.passTournamentId(it))
            }
            // All Tournaments
            Text(text = "All Tournaments", color = Color.White, fontSize = 20.sp, modifier = Modifier.padding(16.dp))
            TournamentList(tournamentList = allTournaments) {
                navController.navigate(Routes.TournamentDetail.passTournamentId(it))
            }

        }

    }
}

@Composable
fun GameReviewTab(comments: List<GameComments>) {

    Column {
        GameDetailReview(comments)
    }
}

@Composable
fun GameRequirementsTab(game: GameModel) {

    LazyColumn {
        item {
            GameDetailRequirements(game = game)
        }
    }
}