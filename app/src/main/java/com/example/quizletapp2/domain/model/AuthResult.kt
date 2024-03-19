package com.example.quizletapp2.domain.model

import com.example.quizletapp2.util.Resource

data class AuthResult(
    val result: Resource<AuthResponseDomain>

)