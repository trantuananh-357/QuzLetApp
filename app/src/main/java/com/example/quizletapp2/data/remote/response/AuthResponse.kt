package com.example.quizletapp2.data.remote.response

import com.example.quizletapp2.data.model.UserDto
import com.google.gson.annotations.SerializedName

data class AuthResponse(
    @SerializedName("data")
    val data : LoginResult?,
    @SerializedName("message")
    val message : String?,
    @SerializedName("errors")
    val errors : ResultError? ,
    @SerializedName("status")
    val status : String?,

)
data class ResultError(
    @SerializedName("email")
    val email : String?,
    @SerializedName("password")
    val password : String?,


)
data class LoginResult(
    @SerializedName("accessToken")
    val accessToken : String,
    @SerializedName("refreshToken")
    val refreshToken : String,
    @SerializedName("tokenExpires")
    val tokenExpires : String,
    @SerializedName("user")
    val user : UserDto

)

