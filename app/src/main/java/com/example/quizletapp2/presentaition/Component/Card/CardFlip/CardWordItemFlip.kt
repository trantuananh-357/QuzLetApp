package com.example.quizletapp2.presentaition.Component.Card.CardFlip

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.quizletapp2.presentaition.Component.Card.Term
import com.wajahatkarim.flippable.FlipAnimationType
import com.wajahatkarim.flippable.Flippable
import com.wajahatkarim.flippable.FlippableController

@Composable
fun CardWordItemFlip(term: Term) {
    var duration: Int by remember { mutableStateOf(400) }
    var flipOnTouchEnabled: Boolean by remember { mutableStateOf(true) }
    val flipEnabled: Boolean by remember { mutableStateOf(true) }
    var autoFlipEnabled: Boolean by remember { mutableStateOf(false) }
    var selectedAnimType: FlipAnimationType by remember { mutableStateOf(FlipAnimationType.VERTICAL_ANTI_CLOCKWISE) }

    val flipController = remember(key1 = "1") {
        FlippableController()
    }

    Flippable(
        modifier = Modifier.fillMaxWidth(),
        frontSide = {
            EnglishWordFrontSide(flipController, term.prompt)
        },
        backSide = {
            EnglishWordBackSide(flipController, term.answer )
        },
        flipController = flipController,
        flipDurationMs = duration,
        flipOnTouch = flipOnTouchEnabled,
        flipEnabled = flipEnabled,
        autoFlip = autoFlipEnabled,
        autoFlipDurationMs = 2000,
        flipAnimationType = selectedAnimType
    )
}
@Composable
fun EnglishWordFrontSide(
    flipController: FlippableController,
    prompt : String
) {
    CardFlip(
    wordAndDefine = prompt,
       onFlip = {
           flipController.flip()
       },
   )
}

@Composable
fun EnglishWordBackSide(
    flipController: FlippableController,
    answer: String
) {
    CardFlip(
        onFlip = {
            flipController.flip()
        },
        wordAndDefine = answer
    )

}


