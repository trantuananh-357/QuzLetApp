package com.example.quizletapp2.domain.model

import com.example.quizletapp2.util.Resource

data class AuthResult(
    val usernameError : String? = null,
    val passwordError : String?  = null,
    val emailError : String?  = null,
    val nameError : String?  = null,
    val result: Resource<Unit>? = null

)