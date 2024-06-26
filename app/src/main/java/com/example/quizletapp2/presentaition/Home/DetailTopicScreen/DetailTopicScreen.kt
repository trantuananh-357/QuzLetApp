package com.example.quizletapp2.presentaition.Home.DetailTopicScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.quizletapp2.R
import com.example.quizletapp2.common.textToSpeechData
import com.example.quizletapp2.presentaition.Component.Card.CardFlip.SlideCardFlip
import com.example.quizletapp2.presentaition.Component.Card.CradNormal.CardNormal
import com.example.quizletapp2.presentaition.Component.Card.Term
import com.example.quizletapp2.presentaition.Component.DragDrop.DragDropList
import com.example.quizletapp2.presentaition.Component.DragDrop.move
import com.example.quizletapp2.presentaition.Component.TopAppBar.TopAppBarView
import com.example.quizletapp2.presentaition.listFeature

@Composable
fun DetailTopicScreen(
    idCard : String?,
    navController: NavController,
    detailTopicScreenViewModel: DetailTopicScreenViewModel = hiltViewModel()
){

    val context = LocalContext.current

    Scaffold (
        modifier = Modifier
            .fillMaxSize()
            .zIndex(100f),
        topBar = {

            TopAppBarView(type = "backstack", navController)

        }

    ) {
        LazyColumn(modifier = Modifier
            .padding(it)
            .fillMaxSize()
        ) {
            item{
                SlideCardFlip(dataTerm)
            }
            item{
                Column (
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp)
                        .fillMaxWidth()

                ){
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Unit1",
                            style =  TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_medium))
                                ))
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(painter = painterResource(id = R.drawable.cloud_arrow_down_solid), contentDescription = "download", modifier = Modifier.size(20.dp))

                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(20.dp),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        IconButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .height(20.dp)
                                .width(20.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.dog) ,
                                contentDescription = "author",
                                modifier = Modifier
                                    .clip(
                                        shape = RoundedCornerShape(100)
                                    )
                                    .width(20.dp)
                                    .height(20.dp),
                                contentScale = ContentScale.Crop
                            )

                        }
                        Text(
                            text = "Trần Tuấn Anh",
                            modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                            style = TextStyle(
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily(Font(R.font.poppins_medium))

                            ),


                            )
                        Divider(
                            modifier = Modifier.width(3.dp),
                            color  = Color.Black
                        )
                        Text(
                            text= "13 thuật ngữ",
                            style = TextStyle(
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily(Font(R.font.poppins_medium))

                            )
                        )
                    }
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.star_solid),
                            contentDescription = "star",
                            modifier = Modifier.size(12.dp),
                            tint = Color.Green
                        )
                        Text(
                            text = "5.0",
                            modifier = Modifier.padding(start = 5.dp, end = 5.dp),
                            style =  TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 10.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_medium))
                                )
                        )
                        Text(
                            text = "(2 lượt đánh giá)",
                            style =  TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 10.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_medium))

                            )
                        )

                    }

                }
            }
            items(listFeature){item ->
                CardNormal(item,navController, idCard)
            }
            item {
                DragDropList(
                    items = dataTerm,
                    onMove = {
                             fromIndex, toIndex -> dataTerm.move(fromIndex, toIndex)

                    },
                    modifier = Modifier.heightIn(max = 10000.dp),
                    detailTopicScreenViewModel
                )
            }

        }




    }
}

val ReorderItem = listOf(
    textToSpeechData(false,"house" ),
    textToSpeechData(false,"house" ),
    textToSpeechData(false,"adad" ),
    textToSpeechData(false,"house" ),
    textToSpeechData(false,"house" ),
    textToSpeechData(false,"house" ),

).toMutableStateList()

val dataTerm = listOf(
    Term("1", "House", "Nhà"),
    Term("2", "Home", "Nhà"),
    Term("3", "Hello every one", "Xin chào mọi người"),
).toMutableStateList()

@Preview(showBackground = true)
@Composable
fun dasd(){
    DetailTopicScreen("dasdas", navController = rememberNavController())
}