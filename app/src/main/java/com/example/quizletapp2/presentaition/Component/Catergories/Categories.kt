package com.example.quizletapp2.presentaition.Component.Catergories

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.quizletapp2.R
import com.example.quizletapp2.presentaition.Component.Card.CardItem
import com.example.quizletapp2.presentaition.Component.Card.CardTopic
import com.example.quizletapp2.presentaition.MainViewModel
import com.example.quizletapp2.presentaition.Screen
import com.google.gson.Gson
import kotlinx.coroutines.launch

@Composable
fun Categories(title : String, listCard : List<CardItem>, navController : NavController){
    val mainViewMode : MainViewModel = viewModel()
    val scope = rememberCoroutineScope()
    Column(modifier = Modifier
        .padding(top = 10.dp, bottom = 10.dp)
        .fillMaxWidth()) {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 15.sp,
                letterSpacing = 1.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.poppins_semibold)
            )),
            modifier = Modifier.padding(bottom = 5.dp)
        )

        LazyRow(userScrollEnabled = true){
            items(listCard){it ->
                CardTopic(
                    item = it,
                    onNavigationToDetailCard = {
                        scope.launch {
                            mainViewMode.setStateScreen()
                        }

                        val json = Uri.encode(Gson().toJson(it.datacard))


                        navController.navigate(Screen.SubScreen.DetailTopicScreen.route + "/$json")

                    }
                )

            }
        }


    }

}

