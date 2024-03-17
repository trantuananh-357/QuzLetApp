package com.example.quizletapp2.presentaition.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizletapp2.common.TextFieldState
import com.example.quizletapp2.domain.use_case.authUseCase.AuthUseCase
import com.example.quizletapp2.domain.use_case.authUseCase.LoginUseCase
import com.example.quizletapp2.util.Resource
import com.example.quizletapp2.util.StateLoading
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
  private val authUseCase: AuthUseCase
)
 : ViewModel(){
     private val _loginState = mutableStateOf(StateLoading())
    val loginState  : State<StateLoading> = _loginState

    private val _usernameState = mutableStateOf(TextFieldState())
    val usernameState : State<TextFieldState> = _usernameState

    private val _passwordState = mutableStateOf(TextFieldState())
    val passwordState  : State<TextFieldState> = _passwordState

    fun setUserName(username : String) {
        _usernameState.value = usernameState.value.copy(text = username)
    }

    fun setPassWord(password : String) {
        _passwordState.value = passwordState.value.copy(text =  password)
    }

    fun loginUser(onNavigation: () -> Unit){
        viewModelScope.launch {
            _loginState.value = loginState.value.copy(isLoading = true)
            val loginResult = authUseCase.loginUseCase(
                username = usernameState.value.text,
                password = passwordState.value.text
            )
            if(loginResult.usernameError != null){
                _usernameState.value = usernameState.value.copy(error = loginResult.usernameError)

            }
            if(loginResult.passwordError != null){
                _passwordState.value = passwordState.value.copy(error = loginResult.passwordError)

            }
            when (loginResult.result){
                is Resource.Success ->{
                    onNavigation()
                }
                is Resource.Error ->{


                }
                else -> {

                }

            }
        }

    }







}