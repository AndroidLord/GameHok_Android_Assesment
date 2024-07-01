package com.example.gamehokandroidassesment.util

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gamehokandroidassesment.model.GameComments


@Composable
fun GameDetailReview(
    comments: List<GameComments>
) {

    comments.forEach {

        GameAnnotatedText(
            boldText = "${it.user}: ",
            regularText = it.comment,
            fontSize = 14.sp,
            textColor = Color.White,
            modifier = Modifier.padding(8.dp)
        )

    }

}