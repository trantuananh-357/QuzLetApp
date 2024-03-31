package com.example.quizletapp2.presentaition.Home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.quizletapp2.R
import com.example.quizletapp2.presentaition.Calendar.CalendarDate.CalendarDate
import com.example.quizletapp2.presentaition.Component.SlideBar
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CalendarScreen(pd : PaddingValues, navController: NavController){
    val dateNow = LocalDate.now()
    val dayOfWeek= dateNow.dayOfWeek
    val dayOfMonth = dateNow.dayOfMonth
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(pd)
            .padding(start  =10.dp, end = 10.dp)
    ){
        item {
            CalendarDate(navController)
        }
        item{
            Text(
                text = "${dayOfWeek}, ${dayOfMonth}th",
                modifier = Modifier.padding(top = 30.dp, start = 20.dp),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 2.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold))
                )


            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun fsdf(){
//    CalendarScreen(PaddingValues(10.dp), navController = rememberNavController())
}