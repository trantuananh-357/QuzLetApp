package com.example.quizletapp2.data.remote

import com.example.quizletapp2.data.remote.request.RequestLogin
import com.example.quizletapp2.data.remote.request.RequestSignIn
import com.example.quizletapp2.data.remote.response.AuthResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiService {
    @POST("auth/register")
    fun signin(@Body requestSignIn: RequestSignIn) : Call<AuthResponse>

    @POST("auth/login")
    fun login(@Body requestLogin: RequestLogin) : Call<AuthResponse>

    @GET("user/{username}")
    suspend fun getAUser()

    @GET("")
    suspend fun getDataUser()




}