package com.example.quizletapp2.presentaition.navigation

import android.content.Intent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.example.quizletapp2.presentaition.Home.CalendarScreen
import com.example.quizletapp2.presentaition.Home.CreatorScreen
import com.example.quizletapp2.presentaition.Home.HomeScreen
import com.example.quizletapp2.presentaition.Home.LibraryScreen
import com.example.quizletapp2.presentaition.Home.LyricTrainingScreen
import com.example.quizletapp2.presentaition.MainViewModel
import com.example.quizletapp2.presentaition.Screen
import com.example.quizletapp2.presentaition.login.LoginScreen
import com.example.quizletapp2.presentaition.signin.SignInScreen

@Composable
fun NavigationGraph(navController: NavHostController, pd : PaddingValues, viewModel : MainViewModel){
    val startScreen = remember {
        mutableStateOf("")
    }
    if(viewModel.stateLogin.value){
        startScreen.value = Screen.BottomBar.Home.route
    }
    else{
        startScreen.value = Screen.ModalBottom.SignIn.route
    }
    NavHost(navController = navController, startDestination = startScreen.value){
        composable(
            route = Screen.ModalBottom.Login.route,
            deepLinks = listOf(
                navDeepLink {
                    uriPattern = "http://192.168.16.102:8000/confirm-email?hash={hash}"
                    action = Intent.ACTION_VIEW
                }
            ),
            arguments = listOf(
                navArgument("hash") {
                    type = NavType.StringType
                    defaultValue = null
                }
            )

        ){
            val hash = it.arguments?.getString("hash")
            LoginScreen(navController = navController, viewModel = viewModel, hash = hash)
        }
        composable(Screen.ModalBottom.SignIn.route){
            SignInScreen(navController)
        }
        composable(Screen.BottomBar.Home.route){
            HomeScreen(pd)
        }
        composable(Screen.BottomBar.Library.route){
            LibraryScreen()
        }
        composable(Screen.BottomBar.Calendar.route){
            CalendarScreen()
        }
        composable(Screen.BottomBar.Create.route){
            CreatorScreen()
        }
        composable(Screen.BottomBar.LyricTraining.route){
            LyricTrainingScreen()
        }


    }

}