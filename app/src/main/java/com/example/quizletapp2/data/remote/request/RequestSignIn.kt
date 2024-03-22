package com.example.quizletapp2.data.remote.request

import com.google.gson.annotations.SerializedName

data class RequestSignIn(
    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("username")
    val username: String,

)