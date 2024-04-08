package com.example.quizletapp2.presentaition.Home.DetailTopicScreen.WriteScreen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.quizletapp2.R
import com.example.quizletapp2.presentaition.Component.IconFun.IconVoice
import com.example.quizletapp2.presentaition.Component.Task.FeatureTask.AddTaskView
import com.example.quizletapp2.presentaition.Component.TopAppBar.TopAppBarView
import com.example.quizletapp2.presentaition.Home.DetailTopicScreen.dataTerm
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WriteScreen (
    navController : NavController
){
    val context = LocalContext.current
    val paperState = rememberPagerState(pageCount = {
        dataTerm.size
    })
    val scope = rememberCoroutineScope()





    Scaffold (
        topBar = {
            TopAppBarView(type = "backpress", navController = navController )
        },
        bottomBar = {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 30.dp, start = 16.dp, end = 16.dp)
            ){
                AddTaskView(
                    onClick = {
                        scope.launch {
                            paperState.animateScrollToPage(
                                paperState.currentPage + 1
                            )
                        }

                    },
                    title = "Submit",
                    color = colorResource(id = R.color.black),
                    modifier = Modifier
                        .clip(RoundedCornerShape(18.dp))
                        .background(colorResource(id = R.color.schedule_primary))
                )
            }

        }


    ){
        HorizontalPager(
            state = paperState,
            modifier = Modifier
                .padding(it)
                .padding(top = 20.dp, start = 16.dp, end = 16.dp),
            userScrollEnabled = false

        ) {
                index ->

            Column {
                Column (
                ){
                    val answer = remember{
                        mutableStateOf("")
                    }
                    val widthUnderLine = ((100/5.9)* dataTerm[index].prompt.length).dp
                    Text(
                        text = "Định Nghĩa",
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.poppins_bold)),
                            color = colorResource(id = R.color.question_title),
                            fontSize = 30.sp
                        )

                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = dataTerm[index].prompt ,
                            style = TextStyle(
                                fontFamily = FontFamily(Font(R.font.poppins_bold)),
                                fontSize = 20.sp
                            ),
                        )
                    }




                    Spacer(modifier = Modifier.height(100.dp))
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {
                        BasicTextField(
                            value = answer.value,
                            onValueChange = {
                                if (it.length <= dataTerm[index].prompt.length) {
                                    answer.value = it
                                }
                            },
                            textStyle = TextStyle(letterSpacing = 6.sp, fontSize = 20.sp ),
                            modifier = Modifier
                                .width(widthUnderLine)
                                .align(Alignment.CenterHorizontally)
                                .padding(0.dp), // Remove padding
                            singleLine = true, // Display in a single line
                            maxLines = 1, // Limit to a single line
                            visualTransformation = VisualTransformation.None
                        )

                        Canvas(
                            modifier = Modifier
                                .width(widthUnderLine)
                        ) {
                            drawLine(
                                color = Color.Black,
                                start = Offset(0f, 0f),
                                end = Offset(size.width, 0f),
                                strokeWidth = 5.dp.toPx(),
                                pathEffect = PathEffect.dashPathEffect(
                                    intervals = floatArrayOf(
                                        40f, // important!
                                        7f, // must be greater than stroke width
                                    ),
                                ),
                            )
                        }
                    }

                }

            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun sdfsd(){
    WriteScreen(navController = rememberNavController())
}