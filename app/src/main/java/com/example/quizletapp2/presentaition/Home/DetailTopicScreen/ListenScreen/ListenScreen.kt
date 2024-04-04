package com.example.quizletapp2.presentaition.Home.DetailTopicScreen.ListenScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.quizletapp2.R
import com.example.quizletapp2.presentaition.Component.IconFun.IconVoice
import com.example.quizletapp2.presentaition.Component.Task.FeatureTask.AddTaskView
import com.example.quizletapp2.presentaition.Component.TopAppBar.TopAppBarView
import com.example.quizletapp2.presentaition.Component.wrapItemAnswer.WrapItemAnswer
import com.example.quizletapp2.presentaition.Home.DetailTopicScreen.DetailTopicScreenViewModel
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun  ListenScreen (
    TextToSpeechViewModel: DetailTopicScreenViewModel = hiltViewModel(),
    navController : NavController
){
    val context = LocalContext.current
    val paperState = rememberPagerState(pageCount = {
        3
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
            Column {
                Column (
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Text(
                        text = "Định Nghĩa",
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.poppins_bold)),
                            color = colorResource(id = R.color.question_title),
                            fontSize = 30.sp
                        )
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Home",
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.poppins_bold)),
                            fontSize = 20.sp
                        )
                    )
                    Image(
                        painter = painterResource(id = R.drawable.drawkit_vector_illustration_black_friday___online_shopping__2_),
                        contentDescription = "imgview",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center

                    )


                }
                Spacer(modifier = Modifier.height(30.dp))
                LazyColumn(){
                    items(4){
                        WrapItemAnswer(onClick = { /*TODO*/ })
                    }
                }
            }

        }



    }

}