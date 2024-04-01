package com.example.quizletapp2.presentaition.Component.Task.TaskInHome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.quizletapp2.R
import com.example.quizletapp2.presentaition.Screen

@Composable
fun TaskItemInHome(item : ScheduleData, navController: NavController){
    var flag = false

    var height : Dp = 0.dp
    if(item.img == null){
            height = 150.dp
            flag = true
        }
        else{
            height = 195.dp
        }


    Box (
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(color = colorResource(id = R.color.schedule_1))
            .height(height)
            .fillMaxWidth()
            .clickable {
                navController.navigate(Screen.BottomBar.Calendar.route)
            }
        ,
    ){

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            if(flag){
                Column (
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Text(
                        text = item.title,
                        minLines = 2,
                        style = TextStyle(fontSize = 15.sp),
                        fontFamily = FontFamily(Font(R.font.poppins_medium))

                    )
                    Text(
                        text = item.time,
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.poppins_medium))
                        )
                    )
                }
            }
            else{
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 18.dp, top = 20.dp),
                ){
                    Text(
                        text = item.title,
                        minLines = 2,
                        style = TextStyle(fontSize = 15.sp),
                        fontFamily = FontFamily(Font(R.font.poppins_medium))


                    )
                    Text(
                        text = item.time,
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.poppins_medium))
                        )
                    )
                }



                item.img?.let { painterResource(id = it) }?.let {
                    Image(painter = it,
                        contentDescription = "img",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop

                    )
                }
            }


        }

    }
}

@Preview(showBackground = true)
@Composable
fun sdfsd(){
    TaskItemInHome(
        ScheduleData(
            "asdad", null, "asdfasd",
        ),
        navController = rememberNavController()
    )
}