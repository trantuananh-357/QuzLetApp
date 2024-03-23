package com.example.quizletapp2.presentaition.DetailTopicScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.zIndex
import com.example.quizletapp2.presentaition.Component.Card.CardWordItem
import com.example.quizletapp2.presentaition.Component.Card.Term
import com.example.quizletapp2.presentaition.Component.LoadingBtnDot.ImageSlideWithIndicator

@Composable
fun DetailTopicScreen(id : String, dataTerm : List<Term>){

    Scaffold (modifier = Modifier.fillMaxSize().zIndex(100f)) {
        Column(modifier = Modifier.padding(it) ) {
            ImageSlideWithIndicator(dataTerm)
        }
    }
}