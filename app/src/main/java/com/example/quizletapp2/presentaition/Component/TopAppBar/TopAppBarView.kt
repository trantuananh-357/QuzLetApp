package com.example.quizletapp2.presentaition.Component.TopAppBar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Icon
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizletapp2.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarView(){
    TopAppBar(

        modifier = Modifier.fillMaxWidth().height(50.dp),
        colors = TopAppBarDefaults.smallTopAppBarColors( // Access default colors
            containerColor = Color.White,
        ),
        title = {
            Row(
                modifier = Modifier.fillMaxWidth().padding(start =  16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,

                ) {
                Row(
                    modifier = Modifier.wrapContentSize()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.download),
                        contentDescription = "App",
                        modifier = Modifier.wrapContentSize().offset(x = -20.dp),
                        contentScale = ContentScale.Fit


                    )
                    Text(
                        modifier = Modifier.offset(x = -60.dp, y= 10.dp).wrapContentSize(),
                        text = stringResource(id = R.string.slogan),
                        color = Color.Black,
                        style = TextStyle(fontSize = 10.sp, fontStyle = FontStyle.Italic)
                    )
                }
                Row(
                    modifier = Modifier.wrapContentSize()
                ) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.magnifying_glass_solid),
                            contentDescription = "Search",
                            modifier = Modifier.size(15.dp)
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.bell_solid),
                            contentDescription = "Notification",
                            modifier = Modifier.size(15.dp)
                        )
                    }

                }



            }

        })
}