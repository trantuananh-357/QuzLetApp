package com.example.quizletapp2.presentaition.DetailTopicScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.quizletapp2.presentaition.Component.Card.CardWordItem

@Composable
fun DetailTopicScreen(id : String){
    Scaffold {
        Column(modifier = Modifier.padding(it) ) {
            CardWordItem()
        }
    }
}