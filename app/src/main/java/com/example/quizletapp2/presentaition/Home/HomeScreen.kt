package com.example.quizletapp2.presentaition.Home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.quizletapp2.R
import com.example.quizletapp2.presentaition.Component.Card.CardItem
import com.example.quizletapp2.presentaition.Component.Card.Term
import com.example.quizletapp2.presentaition.Component.Catergories.Categories
import com.example.quizletapp2.presentaition.Component.Task.TaskInHome.ScheduleData
import com.example.quizletapp2.presentaition.Component.SlideBar
import com.example.quizletapp2.presentaition.Component.Task.TaskInHome.TaskViewInHome

@Composable
fun HomeScreen(pd : PaddingValues, navController: NavController) {
    val listSlide = listOf(
        R.drawable.cat,
        R.drawable.chicken,
        R.drawable.dog,

        )

    val items = listOf(
        ScheduleData(
            title = "Name",
            time = "10:12 - 11:11",
            img = R.drawable.drawkit_vector_illustration_black_friday___online_shopping__3_
        ),
        ScheduleData(
            title = "Name",
            time = "10:12 - 11:11",
            img = null
        ),
        ScheduleData(
            title = "Name",
            time = "10:12 - 11:11",
            img = R.drawable.drawkit_vector_illustration_black_friday___online_shopping__3_
        )
    )



    LazyColumn(
        modifier = Modifier
            .padding(pd)
            .fillMaxSize()
    ) {
        item{
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                SlideBar(listSlide)
            }
        }
        item{
            Row(modifier = Modifier.padding(start = 10.dp, end = 10.dp)) {
                Categories("Phổ Biến", listCard, navController)


            }
            Row(modifier = Modifier.padding(start = 10.dp, end = 10.dp)) {
                Categories("Phổ Biến", listCard, navController)


            }
        }
        item{
            TaskViewInHome(
                items = items,
                modifier = Modifier.heightIn(max = 500.dp),
                navController = navController
            )
        }
    }

}
val listCard = listOf(
    CardItem(
        "1", "Tiếng Anh", 21342, "vitconxuixeo", R.drawable.cat, listOf(
            Term("asd", "House", "Nhà"),
            Term("asd", "House", "Nhà"),
            Term("asd", "House", "Nhà"),
            Term("asd", "House", "Nhà")
        ), pos = 123, "Nhà Cửa"
    ),
    CardItem(
        "2", "Tiếng Nhật", 212, "chuchoxauxi", R.drawable.cat, listOf(
            Term("asd", "House", "Nhà"),
            Term("asd", "House", "Nhà"),
            Term("asd", "House", "Nhà"),
        ),  pos = 123, "Công Nghệ"
    ),
    CardItem(
        "3", "Tiếng Hàn", 42, "conmeobolao", R.drawable.cat, listOf(
            Term("asd", "House", "Nhà"),
            Term("asd", "House", "Nhà"),
            Term("asd", "House", "Nhà"),
        ),  pos = 123, "Xã Hội"
    ),
    CardItem(
        "4", "Tiếng Trung", 21342, "noname", R.drawable.cat, listOf(
            Term("asd", "House", "Nhà"),
            Term("asd", "House", "Nhà"),
            Term("asd", "House", "Nhà"),
            Term("asd", "House", "Nhà"),
        ),  pos = 123, "Marketing"
    ),

    )


@Preview(showBackground = true)
@Composable
fun sdfsdf(){
    HomeScreen(PaddingValues(10.dp), navController = rememberNavController())
}
