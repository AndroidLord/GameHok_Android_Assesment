package com.example.gamehokandroidassesment.widgets

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageSliderWidget(banners: List<Int>, autoSlideInterval: Long = 10000) { // Add autoSlideInterval parameter

    val imagesList = banners

    val pageState = rememberPagerState(pageCount = { imagesList.size })

    var isAutoSlideEnabled by remember { mutableStateOf(true) } // Track auto-slide state

    // Possible error due Threads
//    LaunchedEffect(key1 = pageState, key2 = isAutoSlideEnabled) { // Update on pageState or autoSlideEnabled changes
//        while (isAutoSlideEnabled) {
//            delay(autoSlideInterval)
//            if (pageState.currentPage < pageState.pageCount - 1) {
//                pageState.scrollToPage(pageState.currentPage + 1)
//            } else {
//                pageState.scrollToPage(0) // Loop back to first page
//            }
//        }
//    }

    LaunchedEffect(key1 = pageState, key2 = isAutoSlideEnabled) {
        while (isAutoSlideEnabled) {
            delay(autoSlideInterval)
            // Use Dispatchers.Main to ensure state updates happen on the main thread
            withContext(Dispatchers.Main) {
                if (pageState.currentPage < pageState.pageCount - 1) {
                    pageState.scrollToPage(pageState.currentPage + 1)
                } else {
                    pageState.scrollToPage(0)
                }
            }
        }
    }

    Box(
        modifier = Modifier
            .wrapContentSize()
            .padding(10.dp), contentAlignment = Alignment.Center
    ) {

        HorizontalPager(state = pageState) { page ->

            Row(
                modifier = Modifier.padding(bottom = 15.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    modifier = Modifier.fillMaxWidth().height(180.dp),
                    painter = painterResource(id = imagesList[page]),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
            }
        }

        Spacer(modifier = Modifier.size(20.dp))

        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.Center
        ) {

            repeat(pageState.pageCount) { iteration ->
                val color = if (pageState.currentPage != iteration) Color.Black else Color.LightGray
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(8.dp)
                )

            }
        }
    }
}

