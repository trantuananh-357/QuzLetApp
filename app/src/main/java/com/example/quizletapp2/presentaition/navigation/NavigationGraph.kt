package com.example.quizletapp2.presentaition.navigation

import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
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
import com.example.quizletapp2.presentaition.Calendar.AddTaskCalendarScreen.AddTaskCalendarScreen
import com.example.quizletapp2.presentaition.Component.Card.Term
import com.example.quizletapp2.presentaition.Component.searchScreen.SearchScreen
import com.example.quizletapp2.presentaition.Home.DetailTopicScreen.DetailTopicScreen
import com.example.quizletapp2.presentaition.Home.DetailTopicScreen.ListenScreen.ListenScreen
import com.example.quizletapp2.presentaition.Home.DetailTopicScreen.StudyScreen.StudyScreen
import com.example.quizletapp2.presentaition.Home.DetailTopicScreen.WriteScreen.WriteScreen
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

@RequiresApi(Build.VERSION_CODES.O)
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
                        uriPattern = "http://192.168.196.246:3000/confirm-email?hash={hash}"
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
                LibraryScreen(pd, navController)
            }
        }
        navigation(startDestination = Screen.BottomBar.Calendar.route, route = "calendarscreen"){
            composable(Screen.BottomBar.Calendar.route){
                CalendarScreen(pd, navController)
            }
            composable(Screen.SubScreen.AddTaskCalendar.route){
                AddTaskCalendarScreen(navController)
            }
        }
        navigation(startDestination = Screen.BottomBar.Create.route, route = "createscreen"){
            composable(Screen.BottomBar.Create.route){
                CreatorScreen(pd, navController)
            }
        }
        navigation(startDestination = Screen.BottomBar.LyricTraining.route, route = "lyrictrainingscreen"){
            composable(Screen.BottomBar.LyricTraining.route){
                LyricTrainingScreen()
            }
        }

        composable(Screen.FeatureStudy.Study.route){
            StudyScreen(navController = navController)
        }
        composable(Screen.FeatureStudy.Write.route){
            WriteScreen()
        }
        composable(Screen.FeatureStudy.Listen.route){
            ListenScreen()
        }
        composable(Screen.FeatureStudy.Search.route){
            SearchScreen(navController)
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