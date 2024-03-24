package com.example.quizletapp2.presentaition.Component.TopAppBar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Icon
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quizletapp2.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarView(type : String, navController: NavController){

  @DrawableRes val Icon : Int = if(type == "main") R.drawable.download else R.drawable.arrow_left_solid
    @DrawableRes val notificationIcon : Int = if(type == "main") R.drawable.bell_solid else R.drawable.ellipsis_vertical_solid
    @DrawableRes val searchIcon : Int = if(type == "main") R.drawable.magnifying_glass_solid else 0


    TopAppBar(

        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        colors = TopAppBarDefaults.smallTopAppBarColors( // Access default colors
            containerColor = Color.White,
        ),
        title = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,

                ) {
                Row(
                    modifier = Modifier.wrapContentSize()
                ) {
                    if(Icon == R.drawable.download){
                        Image(
                            painter = painterResource(id = R.drawable.download),
                            contentDescription = "App",
                            modifier = Modifier
                                .wrapContentSize()
                                .offset(x = -20.dp),
                            contentScale = ContentScale.Fit


                        )
                    }
                    else{
                        IconButton(
                            onClick = { navController.navigateUp() },
                            modifier = Modifier.offset(x = -25.dp)

                        ) {
                            Icon(
                                painter = painterResource(id = Icon),
                                contentDescription = "BackPress",
                                modifier = Modifier.size(25.dp).width(30.dp) )
                        }
                    }

                    Text(
                        modifier = Modifier
                            .offset(x = -60.dp, y = 10.dp)
                            .wrapContentSize(),
                        text = if(type == "main") stringResource(id = R.string.slogan) else "",
                        color = Color.Black,
                        style = TextStyle(fontSize = 10.sp, fontStyle = FontStyle.Italic)
                    )
                }
                Row(
                    modifier = Modifier.wrapContentSize()
                ) {
                    IconButton(onClick = { /*TODO*/ }, modifier =Modifier.alpha(if(searchIcon == R.drawable.magnifying_glass_solid) 1f else 0f)) {
                        Icon(
                            painter = painterResource(id = R.drawable.magnifying_glass_solid),
                            contentDescription = "Search",
                            modifier = Modifier.size(20.dp)
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = notificationIcon),
                            contentDescription = "Notification",
                            modifier = Modifier.size(if(notificationIcon == R.drawable.bell_solid) 20.dp else 25.dp).offset(x = if(notificationIcon == R.drawable.bell_solid) 0.dp else 10.dp )
                        )
                    }

                }



            }

        })
}