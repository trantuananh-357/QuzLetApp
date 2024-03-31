package com.example.quizletapp2.presentaition.Component.Task.TaskInHome

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TaskViewInHome(modifier : Modifier = Modifier, items : List<ScheduleData>){




    Row (
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp),
    ){
       LazyVerticalStaggeredGrid(
           columns = StaggeredGridCells.Fixed(2),
           verticalItemSpacing = 22.dp,
           horizontalArrangement = Arrangement.spacedBy(20.dp),
           userScrollEnabled = false
       ){
           items(items){
               TaskItemInHome(item = it)
           }
       }

    }
}

data class ScheduleData (
    val title : String,
    @DrawableRes val img : Int?,
    val time : String
)