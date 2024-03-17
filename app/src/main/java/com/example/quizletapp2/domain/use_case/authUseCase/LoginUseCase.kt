package com.example.quizletapp2.domain.use_case.authUseCase

import com.example.quizletapp2.data.remote.request.RequestLogin
import com.example.quizletapp2.domain.model.AuthResult
import com.example.quizletapp2.domain.repository.AuthRepository
import com.example.quizletapp2.util.Resource

class LoginUseCase (
    private val repository: AuthRepository
){
    suspend operator fun invoke(
        username : String,
        password : String
    ) : AuthResult {

        val userNameError = if(username.isBlank()) "UserName cannot blank!" else null
        val passWordError = if(password.isBlank()) "PassWord cannot blank!" else null

        if(userNameError != null){
            return AuthResult(
                usernameError = userNameError
            )
        }
        if(passWordError != null){
            return AuthResult(
                passwordError = passWordError
            )
        }
        return AuthResult(
            result = repository.login(username, password)
        )
    }
}