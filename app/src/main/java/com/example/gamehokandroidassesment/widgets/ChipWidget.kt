package com.example.gamehokandroidassesment.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gamehokandroidassesment.R
import com.example.gamehokandroidassesment.ui.theme.BaseColor
import com.example.gamehokandroidassesment.ui.theme.BrightGreen


@Composable
fun ChipWidget(
    text: String,
    image: Int,
    onClick: () -> Unit
) {
    OutlinedCard(
        modifier = Modifier,
        onClick = { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = BaseColor
        ),
        shape = RoundedCornerShape(60.dp)
    ) {
        Row(
            modifier = Modifier.padding(5.dp),
//            verticalAlignment = Alignment.CenterVertically, // Center vertically
  //          horizontalArrangement = Arrangement.Center // Center horizontally
        ) {
            Image(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .size(20.dp),
                painter = painterResource(id = image),
                contentDescription = text
            )
            Spacer(modifier = Modifier.padding(3.dp))
            Text(
                text = text,
                color = Color.White,
                fontSize = 15.sp,
                modifier = Modifier
            )
        }
    }
}

@Composable
fun OutlinedText(
    modifier: Modifier = Modifier,
    text: String
) {
    OutlinedCard(
        colors = CardDefaults.cardColors(
            contentColor = BrightGreen,
            containerColor = Color.White.copy(alpha = 0.7f)
        ),
        modifier = Modifier
            .clip(shape = RoundedCornerShape(12.dp))

    ) {
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Black, fontWeight = FontWeight.Medium)) { // Light black color
                    append("Registration End in ")
                }
                withStyle(style = SpanStyle(color = Color.Black, fontWeight = FontWeight.Bold)) { // Bold black color
                    append(text)
                }
            }
            ,
            fontWeight = FontWeight.Bold,
            fontSize = 10.sp,
            color = Color.White,
            modifier = Modifier.padding(start = 4.dp, end = 4.dp)
        )
    }
}

@Composable
fun OutlinedTextWithIcon(
    modifier: Modifier = Modifier,
    text: String,
    icon: Int
) {

    OutlinedCard(
        colors = CardDefaults.cardColors(
            contentColor = BrightGreen,
            containerColor = Color.White.copy(alpha = 0.9f)
        ),
        modifier = Modifier
            .clip(shape = RoundedCornerShape(12.dp))

    ) {

        Row(
            modifier = Modifier.padding(start = 4.dp, end = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = painterResource(id = icon),
                contentDescription = "calendar",
                modifier = Modifier.size(11.dp),
                tint = BrightGreen
            )
            Text(
                text = text,
                fontWeight = FontWeight.Bold,
                fontSize = 10.sp,
                color = Color.White,
            )

        }
    }

}

@Composable
fun OutlinedTextWithImage(
    modifier: Modifier = Modifier,
    text: String,
    image: Int
) {

    OutlinedCard(
        colors = CardDefaults.cardColors(
            contentColor = BrightGreen,
            containerColor = Color.White.copy(alpha = 0.9f)
        ),
        modifier = Modifier
            .clip(shape = RoundedCornerShape(12.dp))

    ) {

        Row(
            modifier = Modifier.padding(start = 4.dp, end = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = image),
                contentDescription = text,
                modifier = Modifier.size(11.dp),
            )

            Text(
                text = text,
                fontWeight = FontWeight.Bold,
                fontSize = 10.sp,
                color = Color.Black,
            )

        }
    }

}