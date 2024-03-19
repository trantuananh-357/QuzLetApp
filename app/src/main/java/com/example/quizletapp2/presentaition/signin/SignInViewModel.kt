package com.example.quizletapp2.presentaition.signin

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.quizletapp2.common.TextFieldState
import com.example.quizletapp2.domain.use_case.authUseCase.AuthUseCase
import com.example.quizletapp2.domain.use_case.authUseCase.SignInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SignInViewModel @Inject constructor(
    private val authUseCase: AuthUseCase
) : ViewModel(){
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







}