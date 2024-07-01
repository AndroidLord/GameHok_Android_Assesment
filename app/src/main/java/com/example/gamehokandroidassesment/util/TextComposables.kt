package com.example.gamehokandroidassesment.util

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun GameOutlinedText(
    modifier: Modifier = Modifier,
    text: String,
    outlineColor: Color = Color.White,
    textColor: Color = Color.Black,
    fontSize: TextUnit = 10.sp,
    fontWeight: FontWeight = FontWeight.Normal
) {
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = outlineColor.copy(alpha = 0.7f)
        ),
        modifier = modifier
            .clip(shape = RoundedCornerShape(12.dp))
    ) {
        Text(
            text = text,
            fontWeight = fontWeight,
            fontSize = fontSize,
            color = textColor,
            modifier = Modifier.padding(start = 4.dp, end = 4.dp)
        )
    }
}

@Composable
fun GameOutlinedAnnotatedText(
    modifier: Modifier = Modifier,
    regularText: String,
    boldText: String,
    outlineColor: Color = Color.White,
    textColor: Color = Color.Black,
    fontSize: TextUnit = 15.sp,
    fontWeight: FontWeight = FontWeight.Normal
) {
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = outlineColor.copy(alpha = 0.7f)
        ),
        modifier = Modifier
            .clip(shape = RoundedCornerShape(12.dp))

    ) {
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontSize = fontSize)) { // Light black color
                    append(regularText)
                }
                withStyle(style = SpanStyle(color = textColor, fontWeight = fontWeight, fontSize = fontSize)) { // Light black color
                    append(boldText)
                }
            },
            modifier = Modifier.padding(start = 4.dp, end = 4.dp)
        )
    }
}


@Composable
fun GameAnnotatedText(
    modifier: Modifier = Modifier,
    regularText: String,
    boldText: String,
    outlineColor: Color = Color.White,
    textColor: Color = Color.Black,
    fontSize: TextUnit = 15.sp,
    fontWeight: FontWeight = FontWeight.Normal
) {

        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = textColor, fontWeight = fontWeight, fontSize = fontSize)) { // Light black color
                    append(boldText)
                }
                withStyle(style = SpanStyle(color = textColor, fontSize = fontSize)) { // Light black color
                    append(regularText)
                }

            },
            modifier = modifier
        )
    }
