package com.example.quizletapp2.presentaition.Component.Card

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizletapp2.R
import com.exyte.animatednavbar.animation.indendshape.shapeCornerRadius

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Card(){
    Card(
        modifier = Modifier
            .padding()
            .width(120.dp)
            .height(60.dp),
        shape = RoundedCornerShape(5.dp),
        onClick = { /*TODO*/ },
        backgroundColor = Color.Gray

    )
    {
        Column {
                Text(
                    text = "Tiếng Nhật",
                    style = TextStyle(color = Color.White, fontSize = 10.sp)
                )
                Text(
                    text = "10 Thuật Ngữ",
                    style = TextStyle(color = Color.White, fontSize = 10.sp)
                )
            Row {
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
                Text(text = "Trần Tuấn Anh" )
            }


        }

    }
}

@Preview(showBackground = true)
@Composable
fun  dasd(){
    Card()
}