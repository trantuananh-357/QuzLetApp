package com.example.quizletapp2.presentaition.Component.Card

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizletapp2.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CardTopic(item : CardItem, onNavigationToDetailCard : () -> Unit){
    Card(
        modifier = Modifier
            .padding(end = 10.dp)
            .width(140.dp)
            .height(80.dp)

        ,
        shape = RoundedCornerShape(5.dp),
        onClick = { onNavigationToDetailCard() },
        backgroundColor = Color.Gray

    )
    {
        Column (
            modifier = Modifier
                .padding(start = 5.dp, end = 5.dp, top = 7.dp, bottom = 5.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = item.subject,
                    style = TextStyle(color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = item.numword.toString(),
                    style = TextStyle(color = Color.White, fontSize = 7.sp),
                    modifier = Modifier
                        .padding(top = 3.dp)
                        .fillMaxWidth()
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.dog) ,
                    contentDescription = "author",
                    modifier = Modifier
                        .clip(
                            shape = RoundedCornerShape(100)
                        )
                        .width(10.dp)
                        .height(10.dp),
                    contentScale = ContentScale.Crop

                )
                Text(
                    text = item.author,
                    style = TextStyle(color = Color.White, fontSize = 8.sp),
                    modifier = Modifier.padding(start = 3.dp)
                )
            }


        }

    }
}

data class CardItem(
    val subject: String,
    val numword : Int,
    val author : String,
   @DrawableRes val imgAuthor: Int

)

