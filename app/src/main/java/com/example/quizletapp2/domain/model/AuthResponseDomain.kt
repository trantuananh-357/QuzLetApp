package com.example.quizletapp2.domain.model

import com.example.quizletapp2.data.model.UserDto

data class AuthResponseDomain(
    val data : LoginResultDomain?,
    val message : String?,
    val errors : ResultErrorDomain? ,
    val status : String?,

)
data class ResultErrorDomain(
    val email : String?,
    val password : String?,


)
data class LoginResultDomain(
    val accessToken : String,
    val refreshToken : String,
    val tokenExpires : String,
    val user : UserDto

)

