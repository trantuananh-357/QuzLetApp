package com.example.quizletapp2.presentaition.Home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.quizletapp2.R
import com.example.quizletapp2.presentaition.Component.SlideBar

@Composable
fun HomeScreen(pd : PaddingValues){
    val listSlide =  listOf(
        R.drawable.cat,
        R.drawable.chicken,
        R.drawable.dog,

        )

    Column(
        modifier = Modifier.padding().padding(pd)
    ) {
        Row(
            modifier = Modifier.height(400.dp).fillMaxWidth()
        ) {
            SlideBar(listSlide)

        }




    }

}