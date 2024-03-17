package com.example.quizletapp2.domain.use_case.authUseCase

data class AuthUseCase(
    val loginUseCase: LoginUseCase,
    val signInUseCase: SignInUseCase
)