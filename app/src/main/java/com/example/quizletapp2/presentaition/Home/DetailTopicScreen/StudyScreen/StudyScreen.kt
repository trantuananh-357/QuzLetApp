package com.example.quizletapp2.presentaition.Home.DetailTopicScreen.StudyScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quizletapp2.presentaition.Component.IconFun.IconVoice


@Composable
fun  StudyScreen(
    studyViewModel: StudyViewModel = hiltViewModel()
){
    val state = studyViewModel.textState.value
    val context = LocalContext.current
    Column {
        Row {
            Text("Ấn vào loa để nghe")
            IconVoice(onClick = {
                studyViewModel.textToSpeech(context)
            }, enabled = state.isButtonEnabled)
        }
        TextField(value = state.text, onValueChange = {item ->
            studyViewModel.onTextStateChange(item)

        })

    }

}

@Preview(showBackground = true)
@Composable
fun sdf(){
StudyScreen(studyViewModel = viewModel())
}