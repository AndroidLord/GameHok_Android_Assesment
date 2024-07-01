package com.example.gamehokandroidassesment.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gamehokandroidassesment.ui.theme.BrightGreen
import com.example.gamehokandroidassesment.ui.theme.HeadingColor

@Composable
fun SectionWidget(
    modifier: Modifier = Modifier,
    heading: String
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = heading,
            fontSize = 16.sp,
            color = HeadingColor
        )
        Text(
            text = "View All",
            fontSize = 16.sp,
            color = BrightGreen
        )
    }

}