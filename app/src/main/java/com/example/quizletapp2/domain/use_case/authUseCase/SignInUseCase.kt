package com.example.quizletapp2.domain.use_case.authUseCase

import com.example.quizletapp2.domain.model.AuthResult
import com.example.quizletapp2.domain.repository.AuthRepository

class SignInUseCase(val repository: AuthRepository) {
    suspend operator fun invoke(
        name: String,
        email: String,
        password: String,
        username: String,
    ): AuthResult {
        return AuthResult(
            result = repository.signin(name, email, password, username)
        )
    }
}