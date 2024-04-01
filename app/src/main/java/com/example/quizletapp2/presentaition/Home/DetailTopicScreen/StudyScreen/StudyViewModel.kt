package com.example.quizletapp2.presentaition.Home.DetailTopicScreen.StudyScreen

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
class StudyViewModel @Inject constructor(

) : ViewModel(){
    private val _textState  = mutableStateOf(textToSpeechData())
    val textState : State<textToSpeechData> = _textState
    private var textToSpeech : TextToSpeech? = null

    fun onTextStateChange(newText : String){
        _textState.value = textState.value.copy(
            text = newText
        )

    }

    fun textToSpeech (context : Context){
        _textState.value = textState.value.copy(
            isButtonEnabled = false
        )
        textToSpeech = TextToSpeech(context){

            if(it == TextToSpeech.SUCCESS){
                textToSpeech?.let {txtToSpeech ->
                    txtToSpeech.language = Locale.US
                    txtToSpeech.speak(
                        _textState.value.text,
                        TextToSpeech.QUEUE_ADD,
                        null,
                        null

                    )
                }
            }
            _textState.value = textState.value.copy(
                isButtonEnabled = true
            )
        }

    }



}