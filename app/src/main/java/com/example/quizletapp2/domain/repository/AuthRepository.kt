package com.example.quizletapp2.domain.repository

import android.provider.ContactsContract.CommonDataKinds.Email
import com.example.quizletapp2.data.remote.request.RequestLogin
import com.example.quizletapp2.data.remote.request.RequestSignIn
import com.example.quizletapp2.domain.model.AuthResponseDomain
import com.example.quizletapp2.util.Resource

interface AuthRepository {
    suspend fun login(username: String, password : String) : Resource<AuthResponseDomain>
    suspend fun signin(name : String, email: String, password: String, username: String) : Resource<AuthResponseDomain>
}