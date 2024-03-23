package com.example.quizletapp2.presentaition

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel  : ViewModel(){
    private val _currentStateForScaffold : MutableState<Screen> = mutableStateOf(Screen.BottomBar.Home)
    val currentStateForScaffold : MutableState<Screen> get() = _currentStateForScaffold

    private val _stateLogin = mutableStateOf(false)
    val stateLogin : State<Boolean> = _stateLogin

    private val _stateScreen = mutableStateOf(false)
    val stateScreen : State<Boolean> = _stateScreen

    fun setStateLogin(){
        _stateLogin.value = !_stateLogin.value
    }
    fun setStateScreen(){
        _stateScreen.value = !_stateScreen.value
        Log.d("onclick", "${stateScreen.value}" )

    }
    
}