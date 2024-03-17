package com.example.quizletapp2.data.repository

import android.util.Log
import com.example.quizletapp2.data.remote.ApiService
import com.example.quizletapp2.data.remote.request.RequestLogin
import com.example.quizletapp2.data.remote.request.RequestSignIn
import com.example.quizletapp2.data.remote.response.AuthResponse
import com.example.quizletapp2.domain.repository.AuthRepository
import com.example.quizletapp2.util.Resource
import kotlinx.coroutines.CoroutineScope
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class AuthRepositoryImpl(private val apiService : ApiService) : AuthRepository {
    override suspend fun login(username : String, password : String) : Resource<Unit>{
        try {
           val res =  apiService.login(RequestLogin(username, password))
            res.enqueue(object : Callback<AuthResponse> {
                override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {

                    val resp =
                        "Response Code : " + response.code() + response.body()?.data?.user + response.message()
                    Log.d("api", resp)

                }

                override fun onFailure(call: Call<AuthResponse?>?, t: Throwable) {
                    // we get error response from API.
                    Log.d("api2", t.message.toString())



                }
            })
            return Resource.Success(Unit)
        }
        catch (e: IOException){
            Log.d("e", e.toString())
            return Resource.Error("${e.message}")

        }
        catch (e: retrofit2.HttpException){
            Log.d("e1", e.toString())
            return Resource.Error("${e.message}")
        }
    }

    override suspend fun signin(name : String, email: String, password: String, username: String) : Resource<Unit>{
        try{
            val res = apiService.signin(RequestSignIn(name, email, username, password))
            res.enqueue(object : Callback<AuthResponse> {
                override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {

                    val resp =
                        "Response Code : " + response.code() + response.body()?.data?.user + response.message()
                    Log.d("sigin", resp)
                }

                override fun onFailure(call: Call<AuthResponse?>?, t: Throwable) {
                    // we get error response from API.
                    Log.d("signin2", t.message.toString())
                }
            })
            return Resource.Success(Unit)

        }
        catch (e :  IOException){
            Log.d("e", e.toString())
            return Resource.Error("${e.message}")

        }
        catch (e: retrofit2.HttpException){
            Log.d("e1", e.toString())
            return Resource.Error("${e.message}")
        }

    }



}