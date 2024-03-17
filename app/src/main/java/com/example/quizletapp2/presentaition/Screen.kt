package com.example.quizletapp2.presentaition

import androidx.annotation.DrawableRes
import com.example.quizletapp2.R

sealed class Screen (val title : String, val route : String) {
    sealed class ModalBottom(val mTitle : String, val mRouter: String, @DrawableRes val icon : Int) : Screen(mTitle, mRouter){
        object Login : ModalBottom(
            mTitle = "Login",
            mRouter = "login",
            R.drawable.google
        )
        object SignIn : ModalBottom(
            mTitle = "SignIn",
            mRouter = "signin",
            R.drawable.facebook
        )

    }

    sealed class BottomBar(val bTitle : String, val bRouter: String, @DrawableRes val icon : Int)
        : Screen(bTitle, bRouter) {
        object Home : BottomBar(
            bTitle = "Home",
            bRouter = "home",
            R.drawable.house_solid
        )
        object Library : BottomBar(
            bTitle = "Library",
            bRouter = "library",
            R.drawable.book_solid
        )
        object Calendar : BottomBar(
            bTitle = "Calendar",
            bRouter = "calendar",
            R.drawable.calendar_solid
        )
        object Create : BottomBar(
            bTitle = "Create",
            bRouter = "create",
            R.drawable.plus_solid
        )
        object LyricTraining : BottomBar(
            bTitle = "Training",
            bRouter = "lyrictraining",
            R.drawable.music_solid
        )

    }
}
val listModal = listOf(
    Screen.ModalBottom.SignIn,
    Screen.ModalBottom.Login,

    )
val listBottomBar = listOf(
    Screen.BottomBar.Home,
    Screen.BottomBar.Library,
    Screen.BottomBar.Calendar,
    Screen.BottomBar.Create,
    Screen.BottomBar.LyricTraining,

    )