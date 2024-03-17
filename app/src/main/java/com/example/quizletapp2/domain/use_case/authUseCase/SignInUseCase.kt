package com.example.quizletapp2.domain.use_case.authUseCase

import com.example.quizletapp2.data.remote.request.RequestSignIn
import com.example.quizletapp2.domain.model.AuthResult
import com.example.quizletapp2.domain.repository.AuthRepository
import com.example.quizletapp2.util.Resource

class SignInUseCase(val repository: AuthRepository) {
    suspend operator fun invoke(
        name : String,
        email : String,
        password : String,
        username : String,
    ) : AuthResult
    {

        val nameError = if(name.isBlank()) "Name cannot blank" else null
        val emailError = if(email.isBlank()) "Email cannot blank" else null
        val passWordError = if(password.isBlank()) "Password cannot blank" else null
        val userNameError = if(username.isBlank()) "UserName cannot blank" else null
        if(nameError != null){
            return AuthResult(
                nameError = nameError
            )
        }
        if(emailError != null){
            return AuthResult(
                emailError = emailError
            )
        }
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
            result = repository.signin(name, email, password, username)
        )
    }
}