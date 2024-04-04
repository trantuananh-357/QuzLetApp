package com.example.quizletapp2.presentaition

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizletapp2.presentaition.Home.listCard
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor()  : ViewModel(){
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