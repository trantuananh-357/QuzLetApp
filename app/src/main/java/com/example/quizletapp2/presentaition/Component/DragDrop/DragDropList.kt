package com.example.quizletapp2.presentaition.Component.DragDrop

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizletapp2.presentaition.Component.IconFun.IconVoice
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


@Composable
fun DragDropList(
    items: List<String>,
    onMove: (Int, Int) -> Unit,
) {
    val scope = rememberCoroutineScope()
    var overScrollJob by remember { mutableStateOf<Job?>(null) }
    val dragDropListState = rememberDragDropListState(onMove = onMove)
    LazyColumn(
            modifier = Modifier
                .pointerInput(Unit) {
                    detectDragGesturesAfterLongPress(

                        onDrag = { change, offset ->
                            change.consumeAllChanges()
                            dragDropListState.onDrag(offset = offset)

                            if (overScrollJob?.isActive == true)
                                return@detectDragGesturesAfterLongPress

                            dragDropListState
                                .checkForOverScroll()
                                .takeIf { it != 0f }
                                ?.let {
                                    overScrollJob = scope.launch {
                                        dragDropListState.lazyListState.scrollBy(it)
                                    }
                                } ?: kotlin.run { overScrollJob?.cancel() }
                        },
                        onDragStart = { offset -> dragDropListState.onDragStart(offset) },
                        onDragEnd = { dragDropListState.onDragInterrupted() },
                        onDragCancel = { dragDropListState.onDragInterrupted() }
                    )
                }
                .padding(top = 10.dp, start = 10.dp, end = 10.dp),



            state = dragDropListState.lazyListState
        ) {
            itemsIndexed(items) { index, item ->
                Column(
                    modifier = Modifier
                        .composed {
                            val offsetOrNull = dragDropListState.elementDisplacement.takeIf {
                                index == dragDropListState.currentIndexOfDraggedItem
                            }
                            Modifier.graphicsLayer {
                                translationY = offsetOrNull ?: 0f
                            }
                        }
                        .background(Color.White, shape = RoundedCornerShape(8.dp))
                        .fillMaxSize()
                ) {
                    Row (
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 20.dp, end = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,


                    ){
                        Text(
                            text = item,
                            fontSize = 10.sp,
                            fontFamily = FontFamily.Serif,
                            color = Color.Gray
                        )
                        IconVoice()




                    }

                }

                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }




@Preview(showBackground = true)
@Composable
fun asda(){

}
