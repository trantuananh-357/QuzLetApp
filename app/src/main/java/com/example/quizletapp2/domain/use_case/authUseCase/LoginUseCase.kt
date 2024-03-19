package com.example.quizletapp2.domain.use_case.authUseCase

import com.example.quizletapp2.domain.model.AuthResult
import com.example.quizletapp2.domain.repository.AuthRepository

class LoginUseCase (
    private val repository: AuthRepository
){
    suspend operator fun invoke(
        username : String,
        password : String
    ) : AuthResult {

        return AuthResult(
            result = repository.login(username, password)
        )
    }
}