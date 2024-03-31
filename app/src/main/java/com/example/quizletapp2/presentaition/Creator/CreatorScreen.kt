package com.example.quizletapp2.presentaition.Home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.quizletapp2.R

@Composable
fun CreatorScreen(pd : PaddingValues, navController: NavController) {
    LazyColumn(
        modifer

    ) {
        item {
            Text(text = "Tạo học phần mới")
            Text(text = "Title")
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
            Text(text = "Description")
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

        }
        item{
            Row {
                TextField(value = "", onValueChange = {})
                TextField(value = "", onValueChange = {})

            }
        }
    }
}
@Preview(showBackground = true, heightDp = 1000)
@Composable
fun sdfgsd(){
    CreatorScreen(PaddingValues(30.dp), navController = rememberNavController())
}