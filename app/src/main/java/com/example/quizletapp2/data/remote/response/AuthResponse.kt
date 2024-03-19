package com.example.quizletapp2.data.remote.response

import com.example.quizletapp2.data.model.UserDto
import com.example.quizletapp2.domain.model.AuthResponseDomain
import com.example.quizletapp2.domain.model.LoginResultDomain
import com.example.quizletapp2.domain.model.ResultErrorDomain
import com.example.quizletapp2.util.Resource
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

) : DataMapper<AuthResponseDomain>(){
    override fun mapToEntity(): AuthResponseDomain {
        return AuthResponseDomain(data?.mapToEntity(), message, errors?.mapToEntity(), status)
    }

}
data class ResultError(
    @SerializedName("email")
    val email : String?,
    @SerializedName("password")
    val password : String?,


) : DataMapper<ResultErrorDomain>(){
    override fun mapToEntity(): ResultErrorDomain {
        return ResultErrorDomain(email, password)
    }
}
data class LoginResult(
    @SerializedName("accessToken")
    val accessToken : String,
    @SerializedName("refreshToken")
    val refreshToken : String,
    @SerializedName("tokenExpires")
    val tokenExpires : String,
    @SerializedName("user")
    val user : UserDto

) : DataMapper<LoginResultDomain>(){
    override fun mapToEntity(): LoginResultDomain {
        return LoginResultDomain(accessToken, refreshToken, tokenExpires, user)
    }

}

//abstract class DataMapper<T>(){
//   fun <T> maptoEntity() {}
//}
abstract class DataMapper<T> {

    abstract fun mapToEntity(): T


}

