package com.example.quizletapp2.presentaition.Calendar.CalendarDate

import android.os.Build
import android.service.autofill.OnClickAction
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizletapp2.R
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Month
import java.util.Date

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CalendarDay(day: Int, month: String, onClickAction: (date : LocalDate) -> Unit, modifier: Modifier = Modifier, isSelected : Boolean) {
    val dateNow = LocalDate.now()
    val monthNow = dateNow.month
    val dayOfMonthNow = dateNow.dayOfMonth


    val date = LocalDate.of(LocalDate.now().year, month.toInt(), day)
    val dayOfWeek = date.dayOfWeek

    val colorActive = remember{
        mutableStateOf(Color.White)
    }
    val backGround = remember {
        mutableStateOf(Color.Transparent)
    }
    Box(
        modifier = modifier
            .width(54.dp)
            .height(74.dp)
            .clip(RoundedCornerShape(14.dp))
            .border(width = 0.2.dp, color = Color.White, shape = RoundedCornerShape(14.dp))
            .clickable {
                colorActive.value = if(colorActive.value == Color.White) Color.Black else Color.White
                onClickAction(date)
                backGround.value = if(backGround.value == Color.Transparent) Color.White else Color.Transparent
            }
            .background(backGround.value)

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                ,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = dayOfWeek.toString().substring(0, 3),
                style = TextStyle(
                    fontSize = 12.sp,
                    color =if(isSelected) Color.Black else colorActive.value,
                    fontFamily = FontFamily(Font(R.font.poppins_light))


                )
            )
            Text(
                text = String.format("%02d",day),
                modifier = Modifier.padding(top = 6.dp,
                    ),
                style = TextStyle(
                    fontSize = 15.sp,
                    color = if(isSelected) Color.Black else colorActive.value,
                    fontFamily = FontFamily(Font(R.font.poppins_bold))
                )

            )
        }
    }



}

@Preview(showBackground = true)
@Composable
fun sdfDF(){
}