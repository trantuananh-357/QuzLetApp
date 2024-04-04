package com.example.quizletapp2.presentaition.Home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.quizletapp2.R
import com.example.quizletapp2.presentaition.Component.Catergories.Categories
import com.example.quizletapp2.presentaition.Component.SlideBar
import com.example.quizletapp2.presentaition.Component.Task.TaskInHome.TaskViewInHome
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LibraryScreen(pd : PaddingValues, navController: NavController){
    val selectedIndex = remember{
        mutableIntStateOf(0)
    }
    val listTab = listOf(
        "Học phần",
        "Lớp"

    )
    val scope = rememberCoroutineScope()
    val paperState = rememberPagerState(pageCount = {listTab.size})

    LaunchedEffect(selectedIndex){
        paperState.animateScrollToPage(selectedIndex.intValue)
    }
    LaunchedEffect(paperState.currentPage){
        selectedIndex.intValue = paperState.currentPage
    }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(pd)
    ) {
        TabRow(
            selectedTabIndex = selectedIndex.intValue,
            backgroundColor = colorResource(id = R.color.schedule_primary),

            ){
            listTab.forEachIndexed{index, item ->
                Tab(
                    selected = index == selectedIndex.intValue,
                    onClick = {
                        selectedIndex.intValue = index
                        scope.launch {
                            paperState.animateScrollToPage(index)
                        }
                    },
                    text = {
                        Text(
                            text = item,
                            style = TextStyle(fontFamily = FontFamily(Font(R.font.poppins_medium)))
                        )
                    }

                )

            }



        }
        HorizontalPager(
            state = paperState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            userScrollEnabled = false
        ) {index ->
            LazyColumn(
                modifier = Modifier
                    .padding(pd)
                    .fillMaxSize()
            ) {
                item{
                    Row(modifier = Modifier.padding(start = 10.dp, end = 10.dp)) {
                        Categories("Phổ Biến", listCard, navController)


                    }
                    Row(modifier = Modifier.padding(start = 10.dp, end = 10.dp)) {
                        Categories("Phổ Biến", listCard, navController)


                    }
                }
            }


        }
    }






}

@Preview(showBackground = true)
@Composable
fun sfsd(){
    LibraryScreen(PaddingValues(top = 30.dp), navController = rememberNavController())
}