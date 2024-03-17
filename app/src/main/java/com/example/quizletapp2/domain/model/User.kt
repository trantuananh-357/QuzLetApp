package com.example.quizletapp2.domain.model

import com.google.gson.annotations.SerializedName

data class User(
    val _id : String,
    val username : String,
    val name : String,
    val avatar : String,
    val createdAt : String,
    val updatedAt : String,
)
