package com.example.gamehokandroidassesment.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
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
import com.example.gamehokandroidassesment.ui.theme.BaseColor
import com.example.gamehokandroidassesment.ui.theme.TextGray
import com.example.gamehokandroidassesment.util.Constants.contactNo
import com.example.gamehokandroidassesment.util.Constants.gmail
import com.example.gamehokandroidassesment.util.Constants.gradient
import com.example.gamehokandroidassesment.util.Constants.organizationDetail
import com.example.gamehokandroidassesment.util.Constants.whatsappNo

@Composable
fun TournamentPrizeRow(
    modifier: Modifier = Modifier,
    rank: String,
    price: Int
) {
    val c1 = Color(25, 41, 32)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(c1)
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.cup_icon),
                contentDescription = "Cup Icon",
                modifier = Modifier.size(width = 20.dp, height = 20.dp)
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = rank,
                color = Color.White
            )

        }
        Row {

            Text(
                text = price.toString(),
                color = Color.White
            )
            Spacer(modifier = Modifier.size(8.dp))
            Image(
                painter = painterResource(id = R.drawable.detail_group_icon),
                contentDescription = "Cup Icon",
                modifier = Modifier.size(width = 20.dp, height = 20.dp)
            )

        }

    }

}


@Composable
fun TournamentPrizeCard(
    modifier: Modifier = Modifier,
    prizeList: List<Pair<String, Int>>
) {
    val totalPrize = prizeList.map { it.second }.sum()

    // make a card with gradient background
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = BaseColor
        )
    ) {
        Column {
            // heading
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(brush = gradient)
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "Total Tournament Prize",
                    color = Color.White,

                    )


                Row() {
                    Text(
                        text = totalPrize.toString(),
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Image(
                        painter = painterResource(id = R.drawable.detail_group_icon),
                        contentDescription = "Cup Icon",
                        modifier = Modifier.size(width = 20.dp, height = 20.dp)
                    )
                }

            }

            // prize list
            prizeList.forEach {
                TournamentPrizeRow(rank = it.first, price = it.second)
                HorizontalDivider(
                    modifier = Modifier.fillMaxWidth(),
                    color = BaseColor,
                    thickness = 2.dp
                )
            }
        }
    }


}


@Composable
fun RoundsAndSchedule(roundDetails: List<List<String>>) {
    OutlinedCard(
        modifier = Modifier.padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = BaseColor
        )
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(brush = gradient)
                    .padding(8.dp)
            ) {
                Text(text = "Rounds", color = Color.White, fontWeight = FontWeight.Medium, modifier = Modifier.weight(1f))
                Text(text = "Round Type", color = Color.White, fontWeight = FontWeight.Medium, modifier = Modifier.weight(1f))
                Text(text = "Promotions", color = Color.White, fontWeight = FontWeight.Medium, modifier = Modifier.weight(1f))
            }

            roundDetails.forEach { currentRound ->
                Row(
                    modifier = Modifier.fillMaxWidth().padding(16.dp)
                ) {
                    Text(text = currentRound[0], color = TextGray, modifier = Modifier.weight(1f))
                    Text(text = currentRound[1], color = TextGray, modifier = Modifier.weight(1f))
                    Text(text = currentRound[2], color = TextGray, modifier = Modifier.weight(1f))
                }
            }
        }
    }
}


@Composable
fun HowToJoinMatch(
    rules: List<String>
) {
    rules.forEach {

        Row(
            modifier = Modifier.padding(start = 16.dp)
        ) {
            Text(
                text = "•",
                color = Color.White
            )
            Spacer(modifier = Modifier.width(4.dp)) // Add a fixed-width spacer for consistent spacing
            Text(
                text = it,
                color = TextGray,
                fontSize = 12.sp,
                modifier = Modifier.fillMaxWidth() // Allow text tooccupy remaining width
            )
        }
    }

}


@Composable
fun OrganiserDetailAndContact(
    modifier: Modifier = Modifier
) {

    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = BaseColor
        )
    ) {
        Column(
            modifier = Modifier
        ) {

            Text(
                text = "Organiser's Details and contact",
                color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = gradient
                    )
                    .padding(8.dp)
            )
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.weight(0.9f)
                ) {
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.detail_group_icon),
                            contentDescription = "Icon",
                            modifier = Modifier.size(width = 20.dp, height = 20.dp)
                        )
                        Spacer(modifier = Modifier.size(8.dp))
                        Text(
                            text = "Gamehok Esports",
                            color = Color.White,
                            fontSize = 16.sp
                        )
                    }
                    Text(
                        text = organizationDetail,
                        color = TextGray,
                        fontSize = 10.sp,
                        lineHeight = 16.sp,
                        modifier = Modifier
                    )

                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0, 51, 22)
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = "Follow")
                }
            }

            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ImageNextText(image = R.drawable.baseline_phone_iphone_24, text = contactNo)
                ImageNextText(image = R.drawable.baseline_mail_outline_24, text = gmail)
            }
            ImageNextText(
                image = R.drawable.whatsapp_icon,
                text = whatsappNo,
                modifier = Modifier.padding(start = 16.dp, bottom = 16.dp)
            )
        }
    }

}

@Composable
fun ImageNextText(
    modifier: Modifier = Modifier,
    image: Int,
    text: String
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(
            painter = painterResource(id = image),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(16.dp)
        )
        Text(text = text, color = TextGray)
    }
}