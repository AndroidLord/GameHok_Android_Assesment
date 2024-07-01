package com.example.gamehokandroidassesment.widgets

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gamehokandroidassesment.model.UserModel
import com.example.gamehokandroidassesment.ui.theme.LightGreen

fun LazyListScope.UserRecommendation(
    modifier: Modifier = Modifier,
    userRecommendations: List<UserModel>
) {

    items(3) { index ->
        val recommendedUser = userRecommendations[index]
        UserRecommendationItem(
            modifier = modifier,
            userRecommendation = recommendedUser
        )
    }

}

@Composable
fun UserRecommendationItem(
    modifier: Modifier = Modifier,
    userRecommendation: UserModel
) {
    Row(
        modifier = modifier
            .padding(start = 8.dp, end = 8.dp, top = 20.dp, bottom = 8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row {
            Image(
                painter = painterResource(id = userRecommendation.image),
                contentDescription = "User",
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = userRecommendation.name,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .height(32.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = LightGreen
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "Follow",
                color = Color.White,
                fontSize = 12.sp,
                modifier = Modifier
            )
        }



    }
}