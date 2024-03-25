package com.example.quizletapp2.presentaition.DetailTopicScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.quizletapp2.R
import com.example.quizletapp2.presentaition.Component.Card.CardFlip.SlideCardFlip
import com.example.quizletapp2.presentaition.Component.Card.CradNormal.CardNormal
import com.example.quizletapp2.presentaition.Component.Card.Term
import com.example.quizletapp2.presentaition.Component.DragDrop.DragDropList
import com.example.quizletapp2.presentaition.Component.DragDrop.move
import com.example.quizletapp2.presentaition.Component.TopAppBar.TopAppBarView

@Composable
fun DetailTopicScreen(idCard : String?, navController: NavController){
    val dataTerm = listOf(
        Term("asd", "House", "Nhà"),
        Term("asd", "House", "Nhà"),
        Term("asd", "House", "Nhà"),
        Term("asd", "House", "Nhà"),
        Term("asd", "House", "Nhà"),
    )

    Scaffold (
        modifier = Modifier
            .fillMaxSize()
            .zIndex(100f),
        topBar = {

            TopAppBarView(type = "backstack", navController)

        }



    ) {
        Column(modifier = Modifier
            .padding(it)
            .fillMaxSize()
        ) {
            SlideCardFlip(dataTerm)
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
                    Text(text = "Unit1", style =  TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp, ))
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
                        style = TextStyle(fontSize = 13.sp, fontWeight = FontWeight.Bold),


                    )
                    Divider(
                        modifier = Modifier.width(3.dp),
                        color  = Color.Black
                    )
                    Text(
                        text= "13 thuật ngữ",
                        style = TextStyle(fontSize = 10.sp, fontWeight = FontWeight.Bold)
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
                        style =  TextStyle(fontWeight = FontWeight.Bold, fontSize = 10.sp, )
                    )
                    Text(
                        text = "(2 lượt đánh giá)",
                        style =  TextStyle(fontWeight = FontWeight.Bold, fontSize = 10.sp, )
                        )

                }
                Column (
                    modifier = Modifier.padding(top = 5.dp).fillMaxWidth()
                ){

                        LazyColumn(){
                            items(dataTerm) {item ->
                                CardNormal()
                            }
                        }

                }
                DragDropList(
                        items = ReorderItem,
                        onMove = { fromIndex, toIndex -> ReorderItem.move(fromIndex, toIndex)}
                )


            }

        }

    }
}

val ReorderItem = listOf(
    "Item 1",
    "Item 2",
    "Item 3",
    "Item 4",
    "Item 5",
    "Item 6",
    "Item 7",
    "Item 8",
    "Item 9",
    "Item 10",
    "Item 11",
    "Item 12",
    "Item 13",
    "Item 14",
    "Item 15",
    "Item 16",
    "Item 17",
    "Item 18",
    "Item 19",
    "Item 20"
).toMutableStateList()

@Preview(showBackground = true)
@Composable
fun dasd(){
    DetailTopicScreen("dasdas", navController = rememberNavController())
}