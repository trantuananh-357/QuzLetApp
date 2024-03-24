package com.example.quizletapp2.presentaition.Component.Card.CardFlip

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quizletapp2.presentaition.Component.Card.Term
import com.example.quizletapp2.presentaition.Component.LoadingBtnDot.Indicator


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SlideCardFlip(images : List<Term>){
    val pageCount = images.size
    val pageState = rememberPagerState(pageCount = {pageCount})
    val scope = rememberCoroutineScope()



    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(start  =  5.dp, end = 5.dp)
            .height(200.dp)
    ){
        HorizontalPager(
            state = pageState,

            ) {index ->
            CardWordItemFlip()
        }
    }
    Row (
        modifier = Modifier
            .fillMaxWidth()

        ,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        repeat(5){interaction ->
            val active = pageState.currentPage == interaction
            Spacer(modifier = Modifier.width(3.dp))
            Indicator(active)
        }
    }



}

@Preview(showBackground = true,
    showSystemUi = true

)
@Composable
fun dasd(){
    val dataTerm = listOf(
        Term("asd", "House", "Nhà"),
        Term("asd", "House", "Nhà"),
        Term("asd", "House", "Nhà"),
        Term("asd", "House", "Nhà")
    )
    SlideCardFlip(dataTerm)
}