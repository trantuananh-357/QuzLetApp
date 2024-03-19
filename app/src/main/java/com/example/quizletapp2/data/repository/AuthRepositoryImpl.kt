package com.example.quizletapp2.data.repository

import android.util.Log
import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.quizletapp2.data.remote.ApiService
import com.example.quizletapp2.data.remote.request.RequestLogin
import com.example.quizletapp2.data.remote.request.RequestSignIn
import com.example.quizletapp2.data.remote.response.AuthResponse
import com.example.quizletapp2.domain.model.AuthResponseDomain
import com.example.quizletapp2.domain.repository.AuthRepository
import com.example.quizletapp2.util.Resource
import kotlinx.coroutines.CoroutineScope
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
import java.io.IOException

class AuthRepositoryImpl(private val apiService : ApiService) : AuthRepository {

    override suspend fun login(username : String, password : String) : Resource<AuthResponseDomain>{
        return try {
            val res =  apiService.login(RequestLogin(username, password)).await()
            Log.d("api", res.data.toString())

            Resource.Success(res.mapToEntity()) // chuyển AuthResspone từ data sang domain
        } catch (e: IOException){
            Log.d("e", e.toString())
            Resource.Error("${e.message}")

        } catch (e: retrofit2.HttpException){
            Log.d("e1", e.toString())
            Resource.Error("${e.message}")
        }
    }

    override suspend fun signin(name : String, email: String, password: String, username: String) : Resource<AuthResponseDomain>{
        return try{
            val res = apiService.signin(RequestSignIn(name, email, username, password)).await()

            Resource.Success(res.mapToEntity())


        } catch (e :  IOException){
            Log.d("e", e.toString())
            Resource.Error("${e.message}")

        } catch (e: retrofit2.HttpException){
            Log.d("e1", e.toString())
            Resource.Error("${e.message}")
        }

    }



}