package com.example.quizletapp2.presentaition.Component.wrapItemAnswer

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizletapp2.presentaition.Component.Card.Term
import kotlin.random.Random
import com.example.quizletapp2.R


@Composable
fun WrapItemAnswer(onClick : ()-> Unit, modifier : Modifier = Modifier){

    val indexResult = (1..4).random()
    val colorResult = if(true) colorResource(id = R.color.answer_right) else colorResource(id = R.color.schedule_primary)
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 10.dp),
//        border = BorderStroke(width = 2.dp, color = colorResource(id = R.color.schedule_primary)),
        shape = RoundedCornerShape(10.dp),


        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                modifier = Modifier
                    .padding(15.dp),
                text = "bac",
                style = TextStyle(fontFamily = FontFamily(Font(R.font.poppins_medium)), fontSize = 20.sp),
                )
        }


    }
}

@Preview(showBackground = true)
@Composable
 fun fs(){
     WrapItemAnswer({} )
 }