package com.example.quizletapp2.presentaition

import android.icu.number.Scale
import android.widget.Space
import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.quizletapp2.R
import com.example.quizletapp2.presentaition.Component.TopAppBar.TopAppBarView
import com.example.quizletapp2.presentaition.Screen.BottomBar.Calendar.title
import com.example.quizletapp2.presentaition.navigation.NavigationGraph
import com.exyte.animatednavbar.AnimatedNavigationBar
import com.exyte.animatednavbar.animation.balltrajectory.Parabolic
import com.exyte.animatednavbar.animation.indendshape.StraightIndent
import com.exyte.animatednavbar.animation.indendshape.shapeCornerRadius
import com.exyte.animatednavbar.utils.noRippleClickable
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(controller : NavHostController){
    val viewModel : MainViewModel = viewModel()
    val currentScaffoldScreen = remember {
        viewModel.currentStateForScaffold.value
    }
    val navBackStackEntry by controller.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    var selectedIndex by remember {
        mutableStateOf(0)
    }
    var showTopBarAndBottomBar by rememberSaveable {
        mutableStateOf(true)
    }
    showTopBarAndBottomBar = when(currentRoute){
        Screen.BottomBar.Home.route -> true
        Screen.BottomBar.Library.route -> true
        Screen.BottomBar.Create.route -> true
        Screen.BottomBar.Calendar.route -> true
        Screen.BottomBar.LyricTraining.route -> true
        else -> false
    }

    val dark = isSystemInDarkTheme()



    for(i in listBottomBar.indices){
        if(listBottomBar[i].route == currentRoute){
            selectedIndex = i
        }
    }
    val login  = viewModel.stateLogin.value
    if(login){

            Scaffold (
                bottomBar = {
                    if(showTopBarAndBottomBar){
                        AnimatedNavigationBar(
                            selectedIndex = selectedIndex,
                            modifier = Modifier.height(64.dp),
                            cornerRadius = shapeCornerRadius(cornerRadius = 34.dp),
                            ballAnimation = Parabolic(tween(300)),
                            ballColor = Color.White,
                            barColor = Color.White,


                            ) {
                            listBottomBar.forEach{item->
                                Box (
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .noRippleClickable {
                                            selectedIndex = listBottomBar.indexOf(item)
                                            controller.navigate(item.route + "screen")
                                        }
                                    ,
                                    contentAlignment = Alignment.Center
                                ){
                                    Icon(
                                        painter = painterResource(id = item.icon),
                                        contentDescription = item.title,
                                        modifier = Modifier.size(20.dp),
                                        tint = if(selectedIndex == listBottomBar.indexOf(item)) Color.Black else Color.Gray
                                    )


                                }
                            }
                        }
                    }


                },
                topBar = {
                    if(showTopBarAndBottomBar){
                        TopAppBarView("main", controller)
                    }
                },

                ){
                NavigationGraph(navController = controller, pd = it,viewModel)
            }



    }
    else{
        NavigationGraph(navController = controller, pd = PaddingValues(30.dp),viewModel)

    }
}






