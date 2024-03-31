package com.example.quizletapp2.presentaition.Calendar.AddTaskCalendarScreen

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Animation
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.RadioButton
import androidx.compose.material.TextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.quizletapp2.R
import com.example.quizletapp2.presentaition.Component.Task.FeatureTask.AddTaskView
import com.example.quizletapp2.presentaition.Component.TopAppBar.TopAppBarView
import io.github.boguszpawlowski.composecalendar.SelectableCalendar
import io.github.boguszpawlowski.composecalendar.SelectableWeekCalendar
import io.github.boguszpawlowski.composecalendar.day.DayState
import io.github.boguszpawlowski.composecalendar.kotlinxDateTime.YearMonth
import io.github.boguszpawlowski.composecalendar.kotlinxDateTime.toJavaYearMonth
import io.github.boguszpawlowski.composecalendar.rememberSelectableCalendarState
import io.github.boguszpawlowski.composecalendar.rememberSelectableWeekCalendarState
import io.github.boguszpawlowski.composecalendar.selection.SelectionMode
import kotlinx.coroutines.launch
import java.time.LocalDate


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AddTaskCalendarScreen(navController: NavController){
    val popupDate = remember{
        mutableStateOf(false)
    }
    val dateChoice = remember{
        mutableStateOf("")
    }
    val calendarState = rememberSelectableCalendarState()


    Scaffold (
        modifier = Modifier
            .fillMaxSize()
            .zIndex(100f)
            .clickable {
                popupDate.value = false
                dateChoice.value =
                    calendarState.selectionState.selection.joinToString { it.toString() }
            }
        ,
        topBar = {

            TopAppBarView(type = "backstack", navController)

        },
        bottomBar = {
            Row (
                modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
            ){
                AddTaskView {
                    navController.navigateUp()
                }
            }

        }


    ){
        LazyColumn (
            modifier = Modifier
                .padding(it)
                .padding(start = 16.dp, end = 16.dp)

        ) {
            item {
                Column(
                    modifier = Modifier.padding(top  = 10.dp)
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Lên lịch trình cho ước mơ của bạn",
                        minLines = 2,
                        textAlign = TextAlign.End,
                        style = TextStyle(fontFamily = FontFamily(Font(R.font.poppins_lightitalic)), fontSize = 30.sp)


                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Title",
                        style = TextStyle(fontFamily = FontFamily(Font(R.font.poppins_semibold))),
                        modifier = Modifier.padding(5.dp)
                        )
                    OutlinedTextField(
                        value = "",
                        onValueChange = {
                        },
                        placeholder = {
                            androidx.compose.material.Text(
                                text = "Enter the title",
                                modifier = Modifier.padding(top = 2.dp),
                                style = TextStyle(fontFamily = FontFamily(Font(R.font.poppins_medium)))
                            )
                        },
                        shape = RoundedCornerShape(18.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                        ,
                        isError = false
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                    Text(
                        text = "Date",
                        style = TextStyle(fontFamily = FontFamily(Font(R.font.poppins_semibold))),
                        modifier = Modifier.padding(5.dp)
                    )
                    OutlinedTextField(
                        value = dateChoice.value,
                        onValueChange = {
                        },

                        modifier = Modifier
                            .fillMaxWidth()
                        ,
                        shape = RoundedCornerShape(18.dp),

                        placeholder = {
                            androidx.compose.material.Text(
                                modifier = Modifier.padding(top = 2.dp),
                                text = "Enter the time",
                                style = TextStyle(fontFamily = FontFamily(Font(R.font.poppins_medium)))
                            )
                        },
                        isError = false,
                        trailingIcon = {

                                    IconButton(onClick = {
                                        popupDate.value = !popupDate.value
                                    }) {
                                        Icon(painter = painterResource(
                                            id = R.drawable.calendar),
                                            contentDescription = "calendar",
                                            modifier = Modifier.size(15.dp)
                                        )
                                    }


                        }
                    )



                }
            }
            item {

            }
            item {

            }


        }

        if(popupDate.value) {
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .fillMaxSize()

                ,

                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .width(300.dp)
                        .heightIn(max = 400.dp)
                        .clip(RoundedCornerShape(18.dp))
                        .background(colorResource(id = R.color.schedule_primary))
                        .padding(10.dp),

                    ){
                    SelectableCalendar(
                        calendarState = calendarState,
                        monthHeader = {monthState -> Text(
                            text = monthState.currentMonth.toString(),
                            style = TextStyle(
                                fontSize = 30.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_bold))
                            ),
                            modifier = Modifier.fillMaxWidth().padding(start = 5.dp),
                            textAlign = TextAlign.Start


                        )  }
                    )
                }
            }

        }
        else{

        }

    }

}




@Preview(showBackground = true)
@Composable
fun sjdfhks(){
    AddTaskCalendarScreen(navController = rememberNavController())
}