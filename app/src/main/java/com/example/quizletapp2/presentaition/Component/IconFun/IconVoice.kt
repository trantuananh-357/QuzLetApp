package com.example.quizletapp2.presentaition.Component.IconFun

import android.media.MediaPlayer
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.example.quizletapp2.R
import com.google.firebase.firestore.EventListener


@Composable
fun IconVoice(onClick :() -> Unit, enabled : Boolean){
    val context = LocalContext.current
    val exoPlayer = remember { ExoPlayer.Builder(context).build() }

//    val audioUri = Uri.parse("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3")

    Column(modifier = Modifier.wrapContentSize()) {

        IconButton(onClick = {
            onClick()
//                val mediaItem = MediaItem.Builder()
//                    .setUri(audioUri)
//                    .build()
//                exoPlayer.setMediaItem(mediaItem)
//                exoPlayer.prepare()
//                exoPlayer.play()

        },
            enabled = enabled
        ) {
            Icon(
                painter = painterResource(id = R.drawable.volume_high_solid),
                contentDescription = "Play/Pause",
                modifier = Modifier.size(20.dp)
            )
        }
    }




}









@Preview(showBackground = true)
@Composable
fun sdfghsdkf(){
    IconVoice({}, false)
}