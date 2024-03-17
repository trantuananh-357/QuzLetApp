package com.example.quizletapp2.data.model

import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("_id")
    val _id : String,
    @SerializedName("username")
    val username : String,
    @SerializedName("name")
    val name : String,
    @SerializedName("avatar")
    val avatar : String,
    @SerializedName("createdAt")
    val createdAt : String,
    @SerializedName("updatedAt")
    val updatedAt : String,
    )