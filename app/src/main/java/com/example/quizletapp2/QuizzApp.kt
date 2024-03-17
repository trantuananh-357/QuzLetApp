package com.example.quizletapp2

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class QuizzApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}