package com.example.quizletapp2.presentaition.Component.Card

import android.os.Parcelable
import android.util.Log
import androidx.activity.compose.BackHandler
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.versionedparcelable.ParcelField
import com.example.quizletapp2.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CardTopic(item : CardItem, onNavigationToDetailCard : () -> Unit){
    Column {
        Card(
            modifier = Modifier
                .padding(end = 20.dp)
                .width(160.dp)
                .height(100.dp)

            ,
            shape = RoundedCornerShape(5.dp),
            onClick = { onNavigationToDetailCard()
            },
            backgroundColor = colorResource(id = R.color.schedule_second)

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
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 10.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_medium))
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text(
                        text = item.numword.toString(),
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 7.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_medium))
                        ),
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
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 8.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_extrabold))

                        ),
                        modifier = Modifier.padding(start = 3.dp)
                    )
                }




            }

        }
        Text(
            text = item.topic,
            style = TextStyle(
                color = Color.Black,
                fontSize = 7.sp,
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                ),
            modifier = Modifier.padding(top = 3.dp)
            )
        Text(
            text = item.pos.toString() + " Lượt học",
            style = TextStyle(
                color = Color.Black,
                fontSize = 7.sp,
                fontFamily = FontFamily(Font(R.font.poppins_medium))
            ),
            modifier = Modifier.padding(top = 3.dp)
            )
    }
  

}

data class CardItem(
    val id : String,
//    val slug: String,
//    val title: String,
//    val description: String,
//    val rate: String,
//    val type: String,
//    val background: String,
//    val share: String,
//    val userId: String,
//    val view: String,
//    val price: Float,


    val subject: String,
    val numword : Int,
    val author : String,
   @DrawableRes val imgAuthor: Int,
    val datacard : List<Term>,
    val pos : Int,
    val topic : String




){
    fun doesMatchSearchQuery(query: String): Boolean {
        val matchingCombinations = listOf(
            "$subject",
        )

        return matchingCombinations.any {
            it.contains(query, ignoreCase = true)
        }
    }
}


data class Term(
    val id : String,
    val prompt : String,
    val answer : String,

//    val pos : Number,
//    val cardId : String,
//    @DrawableRes val image : Int

)

