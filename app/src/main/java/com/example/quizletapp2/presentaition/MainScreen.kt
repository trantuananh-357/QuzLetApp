package com.example.quizletapp2.presentaition

import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.quizletapp2.presentaition.navigation.NavigationGraph
import com.exyte.animatednavbar.AnimatedNavigationBar
import com.exyte.animatednavbar.animation.balltrajectory.Parabolic
import com.exyte.animatednavbar.animation.indendshape.StraightIndent
import com.exyte.animatednavbar.animation.indendshape.shapeCornerRadius
import com.exyte.animatednavbar.utils.noRippleClickable


@Composable
fun MainScreen(controller : NavHostController){
    val viewmodel : MainViewModel = viewModel()
    val viewModel : MainViewModel = viewModel()
    val currentScaffoldScreen = remember {
        viewModel.currentStateForScaffold.value
    }
    val navBackStackEntry by controller.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    var selectedIndex by remember {
        mutableStateOf(0)
    }



    for(i in listBottomBar.indices){
        if(listBottomBar[i].route == currentRoute){
            selectedIndex = i
        }
    }


    val login  = viewModel.stateLogin.value
    if(login){

        Scaffold (
            bottomBar = {
                AnimatedNavigationBar(
                    selectedIndex = selectedIndex,
                    modifier = Modifier.height(64.dp),
                    cornerRadius = shapeCornerRadius(cornerRadius = 34.dp),
                    ballAnimation = Parabolic(tween(300)),
                    ballColor = Color.Black,
                    barColor = Color.White,


                ) {
                    listBottomBar.forEach{item->
                        Box (
                            modifier = Modifier
                                .fillMaxSize()
                                .noRippleClickable {
                                    selectedIndex = listBottomBar.indexOf(item)
                                    controller.navigate(item.route)
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
                            BackHandler(
                                enabled = true, // cho phép xử lý back press
                                onBack = {

                                    controller.navigateUp() // quay lại trang trước
                                }
                            )

                        }

                    }


                }
            }

        ){
            NavigationGraph(navController = controller, pd = it,viewmodel)
        }
    }else{
        NavigationGraph(navController = controller, pd = PaddingValues(10.dp), viewmodel)

    }
}


