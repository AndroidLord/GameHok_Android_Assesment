package com.example.gamehokandroidassesment.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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

@Composable
fun DetailCard(
    modifier: Modifier = Modifier,
    image: Int,
    heading: String,
    subHeading: String,
) {

    Row(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = heading,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(width = 40.dp, height = 34.dp)
                .weight(0.2f)
                .align(Alignment.CenterVertically)
        )
        Column(
            modifier = Modifier.weight(0.8f)
        ) {
            Text(
                text = heading,
                color = Color.Gray,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = subHeading,
                color = Color.White,
                fontSize = 14.sp
            )
        }
    }

}