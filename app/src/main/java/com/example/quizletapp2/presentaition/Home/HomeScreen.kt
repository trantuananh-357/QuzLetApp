package com.example.quizletapp2.presentaition.Home

import android.widget.ScrollView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.quizletapp2.R
import com.example.quizletapp2.presentaition.Component.Card.CardItem
import com.example.quizletapp2.presentaition.Component.Card.Term
import com.example.quizletapp2.presentaition.Component.Catergories.Categories
import com.example.quizletapp2.presentaition.Component.SlideBar
import com.example.quizletapp2.presentaition.Component.TopAppBar.TopAppBarView

@Composable
fun HomeScreen(pd : PaddingValues, navController: NavController){
    val listCa = listOf(
        CardItem("asdasd", "sfsd", 21342, "asdadas", R.drawable.cat, listOf(
            Term("asd", "House", "Nhà"),
            Term("asd", "House", "Nhà"),
            Term("asd", "House", "Nhà"),
            Term("asd", "House", "Nhà")
        )),
        CardItem("asdasd", "sfsd", 21342, "asdadas", R.drawable.cat, listOf(
            Term("asd", "House", "Nhà"),
            Term("asd", "House", "Nhà"),
            Term("asd", "House", "Nhà"),
        )),
        CardItem("asdasd", "sfsd", 21342, "asdadas", R.drawable.cat, listOf(
            Term("asd", "House", "Nhà"),
            Term("asd", "House", "Nhà"),
            Term("asd", "House", "Nhà"),
        )),
        CardItem("asdasd", "sfsd", 21342, "asdadas", R.drawable.cat, listOf(
            Term("asd", "House", "Nhà"),
            Term("asd", "House", "Nhà"),
            Term("asd", "House", "Nhà"),
            Term("asd", "House", "Nhà"),
        )),

    )
    val listSlide =  listOf(
        R.drawable.cat,
        R.drawable.chicken,
        R.drawable.dog,

        )


    Column(
            modifier = Modifier
                .padding()
                .padding(pd)
                .verticalScroll(rememberScrollState()),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                SlideBar(listSlide)
            }
            Row (modifier = Modifier.padding(start = 10.dp, end = 10.dp)){
                Categories("Phổ Biến", listCa, navController )

            }







        }




}
