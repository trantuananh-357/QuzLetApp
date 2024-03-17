package com.example.quizletapp2.di

import com.example.quizletapp2.data.remote.ApiService
import com.example.quizletapp2.data.repository.AuthRepositoryImpl
import com.example.quizletapp2.domain.repository.AuthRepository
import com.example.quizletapp2.domain.use_case.authUseCase.AuthUseCase
import com.example.quizletapp2.domain.use_case.authUseCase.LoginUseCase
import com.example.quizletapp2.domain.use_case.authUseCase.SignInUseCase
import com.example.quizletapp2.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesApiService() : ApiService{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
    @Provides
    @Singleton
    fun providesAuthRepository(
        apiService: ApiService,
    ): AuthRepository {
        return AuthRepositoryImpl(
            apiService = apiService,
        )
    }

    @Provides
    @Singleton
    fun providesLogin(repository: AuthRepository): LoginUseCase {
        return LoginUseCase(repository)
    }

    @Provides
    @Singleton
    fun providesAuth(repository: AuthRepository): AuthUseCase  = AuthUseCase(
        loginUseCase = LoginUseCase(repository),
        signInUseCase = SignInUseCase(repository)
    )










}