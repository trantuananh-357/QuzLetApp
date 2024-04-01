package com.example.quizletapp2.presentaition.Home

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.quizletapp2.R
import com.example.quizletapp2.presentaition.Component.Task.FeatureTask.AddTaskView
import kotlinx.coroutines.launch

@Composable
fun CreatorScreen(pd : PaddingValues, navController: NavController) {
    val context = LocalContext.current
    val ScrollState = rememberScrollState()
    val scope = rememberCoroutineScope()

    val textFieldCount =  remember { mutableStateOf (1) }
    Scaffold (
        bottomBar = {
            AddTaskView(
                onClick = {
                                  navController.navigateUp() },
                title = "Tạo",
                modifier = Modifier
                    .padding(bottom = 80.dp, start = 40.dp, end = 40.dp)
                    .clip(RoundedCornerShape(18.dp))
                    .background(colorResource(id = R.color.schedule_primary))
                ,
                color = Color.White)
        },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(all = 20.dp),
                contentColor = Color.White,
                backgroundColor = colorResource(
                id = R.color.schedule_primary
                ) ,
                onClick = {
                textFieldCount.value++
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)

            }
        }
    ) {

        Column(
            modifier = Modifier
                .padding(it)
                .padding(start = 16.dp, end = 16.dp, top = 50.dp)
                .verticalScroll(ScrollState)

        ) {

                Text(
                    text = "Tạo học phần mới",
                    style = TextStyle(fontFamily = FontFamily(Font(R.font.poppins_bold)), fontSize = 20.sp)

                )
                Spacer(modifier = Modifier.height(50.dp))
                Text(
                    modifier = Modifier.padding(bottom = 10.dp, start =5.dp),
                    text = "Title",
                    style = TextStyle(fontFamily = FontFamily(Font(R.font.poppins_medium)))
                )
                OutlinedTextField(
                    value = "",

                    onValueChange = {
                    },
                    placeholder = {
                        Text(
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
                Spacer(modifier = Modifier.height(50.dp))
                Text(
                    modifier = Modifier.padding(bottom = 10.dp, start  = 5.dp),
                    text = "Description",
                    style = TextStyle(fontFamily = FontFamily(Font(R.font.poppins_medium)))
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {
                    },
                    placeholder = {
                        Text(
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

            Text(
                text = "Từ Vựng",
                modifier = Modifier.padding(top = 20.dp),
                style = TextStyle(fontFamily = FontFamily(Font(R.font.poppins_medium)))
            )


            repeat(textFieldCount.value) {
                Column (
                    modifier = Modifier.padding(top = 10.dp),
                ){
                    TextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        placeholder = {
                            Text(text = "Nhập vào từ ")

                        },
                        onValueChange = {}
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        placeholder = {
                            Text(text = "Nhập vào định nghĩa ")
                        },
                    )
                    Divider(
                        thickness = 2.dp,
                        color = Color.Gray,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                        )

                }
                scope.launch {
                    ScrollState.scrollTo(textFieldCount.value)
                }


            }




        }
    }

}
@Preview(showBackground = true, heightDp = 1000)
@Composable
fun sdfgsd(){
    CreatorScreen(PaddingValues(0.dp), navController = rememberNavController())
}