package com.example.quizletapp2.presentaition.login

import android.util.Log
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
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
  private val authUseCase: AuthUseCase
)
 : ViewModel(){
     private val _loginState = mutableStateOf(StateLoading(false))
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



            when (loginResult.result){
                is Resource.Success ->{
                    _passwordState.value = passwordState.value.copy(error = null)

                    viewModelScope.launch {
                        delay(2000) // Delay for 2 seconds
                        _loginState.value = loginState.value.copy(isLoading = false)
                        onNavigation()
                    }
                    val data = loginResult.result.data
                    Log.d("viewmodel", data.toString())







                }
                is Resource.Error ->{
                    _passwordState.value = TextFieldState("", "Kiếm tra lại mật khẩu và tài khoản")
                    _loginState.value = loginState.value.copy(isLoading = false)



                }
                else -> {
                    _passwordState.value = TextFieldState("", "Kiếm tra lại mật khẩu và tài khoản")


                }

            }
        }

    }







}
