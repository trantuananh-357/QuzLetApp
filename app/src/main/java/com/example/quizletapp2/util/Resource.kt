package com.example.quizletapp2.util

sealed class Resource<out T> {
    data class Success<out T>(val data: T) : Resource<T>()
    data class Loading<out T>(val data: T? = null) : Resource<T>()
    data class Error<out T>(val status: String, val errors: T? = null) : Resource<T>()
}