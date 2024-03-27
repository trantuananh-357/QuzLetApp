package com.example.quizletapp2.presentaition.navigation

import android.content.Intent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import androidx.navigation.navigation
import com.example.quizletapp2.presentaition.Component.Card.Term
import com.example.quizletapp2.presentaition.DetailTopicScreen.DetailTopicScreen
import com.example.quizletapp2.presentaition.DetailTopicScreen.ListenScreen.ListenScreen
import com.example.quizletapp2.presentaition.DetailTopicScreen.StudyScreen.StudyScreen
import com.example.quizletapp2.presentaition.DetailTopicScreen.WriteScreen.WriteScreen
import com.example.quizletapp2.presentaition.Home.CalendarScreen
import com.example.quizletapp2.presentaition.Home.CreatorScreen
import com.example.quizletapp2.presentaition.Home.HomeScreen
import com.example.quizletapp2.presentaition.Home.LibraryScreen
import com.example.quizletapp2.presentaition.Home.LyricTrainingScreen
import com.example.quizletapp2.presentaition.MainViewModel
import com.example.quizletapp2.presentaition.Screen
import com.example.quizletapp2.presentaition.login.LoginScreen
import com.example.quizletapp2.presentaition.signin.SignInScreen
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun NavigationGraph(navController: NavHostController, pd : PaddingValues, viewModel : MainViewModel){
val startScreen = remember {
    mutableStateOf("")
}
    if(viewModel.stateLogin.value){
        startScreen.value = "homescreen"
    }
    else{
        startScreen.value = "authscreen"
    }




    NavHost(navController = navController, startDestination = startScreen.value){


        navigation(startDestination = Screen.ModalBottom.Login.route, route = "authscreen"){
            composable(
                route = Screen.ModalBottom.Login.route,
                deepLinks = listOf(
                    navDeepLink {
                        uriPattern = "http://192.168.16.105:3000/confirm-email?hash={hash}"
                        action = Intent.ACTION_VIEW
                    }
                ),
                arguments = listOf(
                    navArgument("hash"){
                        type = NavType.StringType
                        defaultValue = "none"
                    }

                )



            ){
                val hash = it.arguments?.getString("hash")
                LoginScreen(navController = navController, viewModel = viewModel, hash = hash)
            }
            composable(Screen.ModalBottom.SignIn.route){
                SignInScreen(navController)
            }
            composable(Screen.ModalBottom.ForgotPassword.route){

            }
        }


        ///Bottom
        navigation(startDestination = Screen.BottomBar.Home.route, route = "homescreen"){
            composable(Screen.BottomBar.Home.route){
                HomeScreen(pd, navController)
            }
            composable(
                Screen.SubScreen.DetailTopicScreen.route + "/{idcard}",
                ){navBackStack ->
                val param = navBackStack.arguments?.getString("idcard")
                DetailTopicScreen(param, navController)
            }
        }
        navigation(startDestination = Screen.BottomBar.Library.route, route = "libraryscreen"){
            composable(Screen.BottomBar.Library.route){
                LibraryScreen()
            }
        }
        navigation(startDestination = Screen.BottomBar.Calendar.route, route = "calendarscreen"){
            composable(Screen.BottomBar.Calendar.route){
                CalendarScreen()
            }
        }
        navigation(startDestination = Screen.BottomBar.Create.route, route = "createscreen"){
            composable(Screen.BottomBar.Create.route){
                CreatorScreen()
            }
        }
        navigation(startDestination = Screen.BottomBar.LyricTraining.route, route = "lyrictrainingscreen"){
            composable(Screen.BottomBar.LyricTraining.route){
                LyricTrainingScreen()
            }
        }

        composable(Screen.FeatureStudy.Study.route){
            StudyScreen()
        }
        composable(Screen.FeatureStudy.Write.route){
            WriteScreen()
        }
        composable(Screen.FeatureStudy.Listen.route){
            ListenScreen()
        }









    }


}


@Composable
fun NavBackStackEntry.shareViewModel(navController: NavHostController) : ViewModel {
    val navGraphRoute = destination.parent?.route ?: return hiltViewModel()
    val parentEntry = remember(this){
        navController.getBackStackEntry(navGraphRoute)
    }
    return hiltViewModel(parentEntry)
}