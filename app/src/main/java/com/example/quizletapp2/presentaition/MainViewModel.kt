package com.example.quizletapp2.presentaition

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel  : ViewModel(){
    private val _currentStateForScaffold : MutableState<Screen> = mutableStateOf(Screen.BottomBar.Home)
    val currentStateForScaffold : MutableState<Screen> get() = _currentStateForScaffold

    private val _stateLogin = mutableStateOf(false)
    val stateLogin : State<Boolean> = _stateLogin

    fun setStateLogin(){
        _stateLogin.value = !_stateLogin.value
    }
}