package com.example.gamehokandroidassesment.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gamehokandroidassesment.R
import com.example.gamehokandroidassesment.model.TournamentModel
import com.example.gamehokandroidassesment.navigations.Routes
import com.example.gamehokandroidassesment.ui.theme.BaseColor
import com.example.gamehokandroidassesment.util.allDateFormat
import com.example.gamehokandroidassesment.util.getTournamentList

@Composable
fun TournamentTabs(
    modifier: Modifier = Modifier,
    tournament: TournamentModel,
    navController: NavController
) {

    val tabList = listOf("Overview", "Players", "Rules", "Standings")
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
                    text = { Text(title, fontSize = 12.sp, color = if (selectedTabIndex == index) Color.White else Color.LightGray) },
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index }
                )
            }
        }

        when (selectedTabIndex) {
            0 -> TournamentOverviewTab(tournament,navController)
            1 -> TournamentPlayersTab()
            2 -> TournamentRulesTab(tournament.tournamentDetail.rules)
            3 -> TournamentStandingsTab()
        }
    }

}


@Composable
fun TournamentOverviewTab(tournament: TournamentModel, navController: NavController) {

    val tournamentDay = allDateFormat(tournament.tournamentDetail.tournamentStart)
    val checkInMessage = "${tournament.tournamentDetail.checkIn} the match starts"
    val otherTournaments = getTournamentList().filter { it.id != tournament.id}

    Box(modifier = Modifier.fillMaxWidth()){
        LazyColumn {

            item {
                Text(
                    text = "Details",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
                DetailCard(image = R.drawable.team_size_icon,heading = "TEAM SIZE",subHeading = tournament.tournamentDetail.teamSize)
                DetailCard(image = R.drawable.format_icon,heading = "FORMAT",subHeading = tournament.tournamentDetail.format)
                DetailCard(image = R.drawable.detail_calendar_icon, heading = "TOURNAMENT STARTS", subHeading = tournamentDay)
                DetailCard(image = R.drawable.check_in_icon, heading = "CHECK-IN", subHeading = checkInMessage)
                TournamentPrizeCard(prizeList=tournament.tournamentDetail.prize)
                Text(
                    text = "Rounds and Schedule",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
                RoundsAndSchedule(tournament.tournamentDetail.RoundAndSchedule)
                Text(
                    text = "How to Join a Match",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
                HowToJoinMatch(rules = tournament.tournamentDetail.rules)
                OrganiserDetailAndContact()
                Spacer(modifier = Modifier.size(16.dp))
                Text(text = "More tournaments for you",color= Color.White,modifier=Modifier.padding(start=16.dp))
                TournamentList(tournamentList = otherTournaments){ index->
                    // Handle click event
//                Log.d("Home_1", "Home: $index")
                    navController.navigate(Routes.TournamentDetail.passTournamentId(index))
                }
                Spacer(modifier = Modifier.padding(vertical = 32.dp))
            }


        }
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(1, 183, 82)
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomCenter)
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


@Composable
fun TournamentPlayersTab() {

    Box(modifier = Modifier.fillMaxWidth()){

        Text(text = "No Players Registered",color = Color.White,modifier = Modifier.padding(16.dp).align(Alignment.Center))
    }
}

@Composable
fun TournamentRulesTab(rules: List<String>) {

    Column {
        HowToJoinMatch(rules = rules)
    }
}

@Composable
fun TournamentStandingsTab() {

    Box(modifier = Modifier.fillMaxWidth()){
        Text(text = "No Standing",color = Color.White,modifier = Modifier.padding(16.dp).align(Alignment.Center))
    }
}
