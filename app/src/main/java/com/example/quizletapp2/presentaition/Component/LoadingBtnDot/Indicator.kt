package com.example.quizletapp2.presentaition.Component.LoadingBtnDot

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.quizletapp2.presentaition.Component.Card.CardWordItem
import com.example.quizletapp2.presentaition.Component.Card.Term
import kotlinx.coroutines.delay


@Composable
fun Indicator(active : Boolean){
    val color = if(active) Color.Black else Color.White
    val size = if(active) 10.dp else 15.dp
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(color)
            .size(size)
    )
}



@Composable
fun ImageSlideWithIndicator(images : List<Term>){
    val currentIndex = remember {
        mutableStateOf(0)
    }
    LaunchedEffect(Unit){
        while(true){
            delay(3000)
            currentIndex.value = (currentIndex.value + 1) % images.size


        }
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .padding(top = 10.dp)
                .weight(1f)


        ){
            CardWordItem()
        }
        Row (modifier = Modifier.padding(start = 170.dp, end = 170.dp))
        {
            images.forEachIndexed{index, i ->
                Indicator(active = index == currentIndex.value)
                if(index < images.size){
                    Spacer(modifier = Modifier.width(5.dp))
                }
            }

        }
    }
}