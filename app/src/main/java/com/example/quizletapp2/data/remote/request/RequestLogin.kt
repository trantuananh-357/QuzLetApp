package com.example.quizletapp2.data.remote.request

import com.google.gson.annotations.SerializedName

data class RequestLogin(
    @SerializedName("username")
    val username : String,
    @SerializedName("password")
    val password : String,

)
