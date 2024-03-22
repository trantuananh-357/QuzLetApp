package com.example.quizletapp2.presentaition.Component.Catergories

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quizletapp2.R
import com.example.quizletapp2.presentaition.Component.Card.CardItem
import com.example.quizletapp2.presentaition.Component.Card.CardTopic
import com.example.quizletapp2.presentaition.Screen

@Composable
fun Categories(title : String, listCard : List<CardItem>, navController : NavController){
    Column(modifier = Modifier.padding(top = 10.dp, bottom = 10.dp).fillMaxWidth()) {
        Text(
            text = title,
            style = TextStyle(fontSize = 15.sp, letterSpacing = 1.sp, fontWeight = FontWeight.Bold, color = Color.White),
            modifier = Modifier.padding(bottom = 5.dp)
        )
        LazyRow(userScrollEnabled = true){
            items(listCard){it ->
                CardTopic(
                    item = it,
                    onNavigationToDetailCard = {
                        navController.navigate(Screen.SubScreen.DetailTopicScreen.route)

                    }  )
            }
        }


    }

}

