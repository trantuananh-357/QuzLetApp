package com.example.quizletapp2.presentaition.Component

import android.icu.util.LocaleData.PaperSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quizletapp2.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SlideBar(listSlide : List<Int>){
    val paperState = rememberPagerState(
        pageCount = {
            3
        }
    )
    val scope  = rememberCoroutineScope();
    Box(modifier = Modifier.fillMaxWidth()) {
            HorizontalPager(

                state = paperState,
                key = { listSlide[it] },
                pageSize = PageSize.Fill,
                modifier = Modifier.height(150.dp),
                verticalAlignment = Alignment.CenterVertically
            ) { item ->
                Image(
                    painter = painterResource(id = listSlide[item]),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )
            }
//            Box(
//                modifier = Modifier
//                    .wrapContentSize()
//                    .clip(RoundedCornerShape(100))
//                    .background(MaterialTheme.colors.background)
//                    .padding(8.dp)
//                    .align(Alignment.CenterStart)
//            ) {
//                IconButton(
//                    onClick = {
//                        scope.launch {
//                            paperState.animateScrollToPage(
//                                paperState.currentPage - 1
//                            )
//                        }
//                    },
//                    modifier = Modifier.align(Alignment.CenterStart)
//                ) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.chevron_left_solid),
//                        contentDescription = "Left Back",
//                        modifier = Modifier.size(20.dp)
//                        )
//                }
//
//            }
//            Box(
//                modifier = Modifier
//                    .wrapContentSize()
//                    .clip(RoundedCornerShape(100))
//                    .background(MaterialTheme.colors.background)
//                    .padding(8.dp)
//                    .align(Alignment.CenterEnd)
//            ){
//            IconButton(
//                onClick = {
//                    scope.launch {
//                        paperState.animateScrollToPage(
//                            paperState.currentPage + 1
//                        )
//                    }
//                },
//                modifier = Modifier.align(Alignment.CenterEnd)
//            ) {
//                Icon(
//                    painter = painterResource(id = R.drawable.chevron_right_solid),
//                    contentDescription = "Right Back",
//                    modifier = Modifier.size(20.dp)
//                )
//            }
//            }
        }

}


