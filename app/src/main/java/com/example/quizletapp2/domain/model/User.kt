package com.example.quizletapp2.domain.model

import com.example.quizletapp2.data.model.UserDto
import com.google.gson.annotations.SerializedName

data class User(
    val _id : String,
    val username : String,
    val name : String,
    val avatar : String,
    val createdAt : String,
    val updatedAt : String,
)

data class authResponseUseCase(
    val data :LoginResultUseCase,
    val message : String
)

data class LoginResultUseCase(
    val accessToken : String,
    val refreshToken : String,
    val tokenExpires : String,
    val user : UserDto

)
data class ResultErrorUseCase(
    @SerializedName("email")
    val email : String?,
    @SerializedName("password")
    val password : String?,


    )
