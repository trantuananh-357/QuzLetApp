package com.example.quizletapp2.presentaition.Home.DetailTopicScreen

import android.content.Context
import android.speech.tts.TextToSpeech
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.quizletapp2.common.textToSpeechData
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Locale
import javax.inject.Inject


@HiltViewModel
class DetailTopicScreenViewModel @Inject constructor() : ViewModel() {
    private var textToSpeech : TextToSpeech? = null


    fun textToSpeech (context : Context, word : String){

        textToSpeech = TextToSpeech(context){

            if(it == TextToSpeech.SUCCESS){
                textToSpeech?.let {txtToSpeech ->
                    txtToSpeech.language = Locale.US
                    txtToSpeech.speak(
                        word,
                        TextToSpeech.QUEUE_ADD,
                        null,
                        null

                    )
                }
            }

        }

    }
}