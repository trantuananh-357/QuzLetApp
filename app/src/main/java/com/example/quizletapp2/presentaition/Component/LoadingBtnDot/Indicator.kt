package com.example.quizletapp2.presentaition.Component.LoadingBtnDot

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.quizletapp2.R


@Composable
fun Indicator(active : Boolean){
    val color = if(active) colorResource(id = R.color.schedule_primary) else colorResource(id = R.color.schedule_second)
    val size = if(active) 10.dp else 5.dp
    val shape = if(active) CircleShape else CircleShape
    Box(
        modifier = Modifier
            .clip(shape)
            .background(color)
            .size(size)

    )
}


