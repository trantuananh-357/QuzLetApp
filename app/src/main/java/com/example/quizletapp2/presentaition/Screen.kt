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
        object ForgotPassword : ModalBottom(
            mTitle = "ForgotPassword",
            mRouter = "forgotpassword",
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
        object Create : BottomBar(
            bTitle = "Create",
            bRouter = "create",
            R.drawable.plus_solid
        )
        object Calendar : BottomBar(
            bTitle = "Calendar",
            bRouter = "calendar",
            R.drawable.calendar_solid
        )

        object LyricTraining : BottomBar(
            bTitle = "Training",
            bRouter = "lyrictraining",
            R.drawable.music_solid
        )

    }
    sealed class SubScreen(val sTitle : String, val sRouter: String, @DrawableRes val icon : Int) : Screen(sTitle, sRouter){
        object DetailTopicScreen : SubScreen(
            sTitle = "DetailTopicScreen",
            sRouter = "detailtopicscreen",
            R.drawable.house_solid
        )
        object AddTaskCalendar : SubScreen(
            sTitle = "AddTaskCalendar",
            sRouter = "addtaskcalendar",
            R.drawable.house_solid
        )
    }

    sealed class FeatureStudy(val fTitle : String, val fRouter: String, @DrawableRes val icon : Int) : Screen(fTitle, fRouter){
        object Study : FeatureStudy(
            fTitle = "Học",
            fRouter = "study",
            R.drawable.bookmark_solid
        )
        object Write : FeatureStudy(
            fTitle = "Viết",
            fRouter = "write",
            R.drawable.pen_nib_solid
        )
        object Listen : FeatureStudy(
            fTitle = "Nghe",
            fRouter = "listen",
            R.drawable.headphones_solid
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
    Screen.BottomBar.Create,
    Screen.BottomBar.Calendar,
    Screen.BottomBar.LyricTraining,

    )

val listFeature =  listOf(
    Screen.FeatureStudy.Study,
    Screen.FeatureStudy.Write,
    Screen.FeatureStudy.Listen,

)
