package com.example.quizletapp2.presentaition.signin

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizletapp2.common.TextFieldState
import com.example.quizletapp2.domain.use_case.authUseCase.AuthUseCase
import com.example.quizletapp2.domain.use_case.authUseCase.SignInUseCase
import com.example.quizletapp2.util.Resource
import com.example.quizletapp2.util.StateLoading
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SignInViewModel @Inject constructor(
    private val authUseCase: AuthUseCase
) : ViewModel(){
    private val _loginState = mutableStateOf(StateLoading(false))
    val loginState  : State<StateLoading> = _loginState

    private val _nameState = mutableStateOf(TextFieldState())
    val nameState : State<TextFieldState> = _nameState

    private val _emailState = mutableStateOf(TextFieldState())
    val emailState : State<TextFieldState> = _emailState

    private val _passwordState = mutableStateOf(TextFieldState())
    val passwordState : State<TextFieldState> = _passwordState

    private val _usernameState = mutableStateOf(TextFieldState())
    val usernameState : State<TextFieldState> = _usernameState

    fun setName(newName : String){
        _nameState.value = nameState.value.copy(text = newName)
    }

    fun setEmail(newEmail : String){
        _emailState.value = emailState.value.copy(text = newEmail)
    }

    fun setPassword(newPassword : String){
        _passwordState.value = passwordState.value.copy(text = newPassword)
    }

    fun setUsername(newUsername : String){
        _usernameState.value = usernameState.value.copy(text = newUsername)
    }

    fun singInUser(onNavigation : () -> Unit){
        viewModelScope.launch {
            _loginState.value = loginState.value.copy(isLoading = true)
            val signInResult = authUseCase.signInUseCase(
                name = nameState.value.text,
                email = emailState.value.text,
                password = passwordState.value.text,
                username = usernameState.value.text,

            )
            when(signInResult.result){
                is Resource.Success -> {
                    val data = signInResult.result.data
                    _loginState.value = loginState.value.copy(isLoading = false)
                    onNavigation()
                    Log.d("singin", data.status.toString())



                }
                is Resource.Error -> {
                    _loginState.value = loginState.value.copy(isLoading = false)
                    Log.d("errorSignIn", signInResult.result.message)
                }
                else ->{

                }
            }
        }
    }







}