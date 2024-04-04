package com.example.quizletapp2.presentaition.Calendar.CalendarDate

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
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
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.quizletapp2.R
import com.example.quizletapp2.presentaition.Component.Task.FeatureTask.AddTaskView
import com.example.quizletapp2.presentaition.Screen
import com.exyte.animatednavbar.animation.indendshape.shapeCornerRadius

import kotlinx.coroutines.launch
import java.time.LocalDate
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CalendarDate(navController: NavController) {
    val pageCount = 12
    val pageState = rememberPagerState(
        pageCount = { pageCount }
    )
    val dateNow = LocalDate.now()
    val monthNow = dateNow.month.value
    val dayOfWeekNow = dateNow.dayOfWeek.value
    val dayOfMonthNow = dateNow.dayOfMonth




    val month = remember{
        mutableStateOf(monthNow)
    }
    val year = remember{
        mutableStateOf(LocalDate.now().year)
    }
    val now = remember {
        mutableStateOf("")
    }
    val date = remember {
        derivedStateOf {
            LocalDate.of(year.value, month.value, 1) // Use day 1 to avoid potential edge cases
        }
    }


    val monthOfYear = date.value.month
    val dayInMonth = monthOfYear.length(false)
    val LazyState = rememberLazyListState()


    
    val scope = rememberCoroutineScope()
    Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(33.dp))
                .background(
                    colorResource(id = R.color.schedule_primary)
                )

        ) {
            Column (
                modifier = Modifier
                    .height(299.dp)

            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 40.dp, start = 10.dp, end = 10.dp)

                    ,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){

                    IconButton(
                        onClick = {
                            scope.launch {
                                pageState.animateScrollToPage(
                                    (pageState.currentPage - 1) % pageCount
                                )
                            }
                            month.value = if((month.value - 1) == 0) 12 else (month.value - 1)

                        },
                        modifier = Modifier.wrapContentSize()

                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.chevron_left_solid),
                            contentDescription = "Go back",
                            modifier = Modifier.size(20.dp),
                            tint = Color.White


                        )
                    }
                    HorizontalPager(
                        state = pageState,
                        modifier = Modifier
                            .width(200.dp),
                        userScrollEnabled = false
                    ) { index ->
                        Text(
                            text = monthOfYear.toString().replaceFirstChar { it.uppercaseChar() },
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.White,
                                fontFamily = FontFamily(Font(R.font.poppins_semibold)
                                )
                            ),
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )

                    }
                    IconButton(
                        onClick = {
                            scope.launch {
                                pageState.animateScrollToPage(
                                    (pageState.currentPage + 1) % pageCount
                                )
                            }
                            month.value = if(month.value + 1 == 13) 1 else (month.value + 1) % 13

                        },
                        modifier = Modifier.wrapContentSize()

                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.chevron_right_solid),
                            contentDescription = "Go forward",
                            modifier = Modifier.size(20.dp),
                            tint = Color.White
                        )
                    }
                }
                LazyRow(
                    modifier = Modifier.padding(top = 29.dp, start = 16.dp, end = 16.dp, bottom = 29.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    state = LazyState
                ) {


                    items(dayInMonth) {index->
                        val isSelected = index + 1 == dayOfMonthNow && month.value == monthNow
                        CalendarDay(day = index + 1, month =  month.value.toString(), onClickAction =  {
                            date ->
                            now.value = "${date.year} - ${date.month} - ${date.dayOfMonth}"
                        },
                            modifier = if(isSelected){
                                Modifier
                                    .clip(RoundedCornerShape(14.dp))
                                    .background(Color.White)


                            } else {
                                Modifier
                            },
                            isSelected = isSelected

                        )
                    }
                    scope.launch {
                        LazyState.scrollToItem(dayOfMonthNow)
                    }





                }
                Row(
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                ) {
                    AddTaskView(
                        onClick = {navController.navigate(Screen.SubScreen.AddTaskCalendar.route)},
                        "Add Task",
                        modifier = Modifier
                            .clip(RoundedCornerShape(18.dp))
                            .background(Color.White),
                        color = Color.Black

                    )
                }
            }
        }


    }




@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun fsdhkf(){
    CalendarDate(navController = rememberNavController())
}

//@RequiresApi(Build.VERSION_CODES.O)
//@Composable
//fun MyDay(dayState: Day) {
//    Text(dayState.date.dayOfMonth.toString())
//}
//
//@RequiresApi(Build.VERSION_CODES.O)
//@Composable
//fun asdas() {
//    StaticCalendar(
//        dayContent = { dayState -> MyDay(dayState) }
//    )
//}