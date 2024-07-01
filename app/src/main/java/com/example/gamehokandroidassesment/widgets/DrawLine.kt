package com.example.gamehokandroidassesment.widgets

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DrawLine() {
    Canvas(
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 8.dp)
            .fillMaxWidth()
    ){
        drawLine(
            color = Color.Gray,
            start = Offset(0f, 0f),
            end = Offset(size.width, 0f),
            strokeWidth = 4f
        )
    }
}