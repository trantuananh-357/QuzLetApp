package com.example.quizletapp2.presentaition.login

import android.util.Log
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asComposePath
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.graphics.shapes.CornerRounding
import androidx.graphics.shapes.Morph
import androidx.graphics.shapes.RoundedPolygon
import androidx.graphics.shapes.toPath
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.quizletapp2.R
import com.example.quizletapp2.presentaition.MainViewModel
import com.example.quizletapp2.presentaition.Screen
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph


@Composable
fun LoginScreen(
    navController : NavController,
    loginViewModel: LoginViewModel = hiltViewModel(),
    viewModel: MainViewModel
) {
    val infiniteAnimation = rememberInfiniteTransition(label = "infinite animation")
    val morphProgress = infiniteAnimation.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            tween(500),
            repeatMode = RepeatMode.Reverse
        ),
        label = "morph"
    )
    /////

    val username = loginViewModel.usernameState.value
    val password = loginViewModel.passwordState.value
    val loginState = loginViewModel.loginState.value


    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState

    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .padding(start = 32.dp, end = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            Text(
                text = stringResource(id = R.string.login).uppercase(),
                style = TextStyle(fontSize = 35.sp, fontWeight = FontWeight.ExtraBold)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(modifier = Modifier
                    .drawWithCache {
                        val triangle = RoundedPolygon(
                            numVertices = 3,
                            radius = size.minDimension / 2f,
                            centerX = size.width / 2f,
                            centerY = size.height / 2f,
                            rounding = CornerRounding(
                                size.minDimension / 10f,
                                smoothing = 0.1f
                            )
                        )
                        val square = RoundedPolygon(
                            numVertices = 4,
                            radius = size.minDimension / 2f,
                            centerX = size.width / 2f,
                            centerY = size.height / 2f
                        )

                        val morph = Morph(start = triangle, end = square)
                        val morphPath = morph
                            .toPath(progress = morphProgress.value)
                            .asComposePath()

                        onDrawBehind {
                            drawPath(morphPath, color = Color.Black)
                        }
                    }
                    .padding(2.dp)
                ) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.google),
                            contentDescription = "google",
                            modifier = Modifier.size(20.dp),
                            tint = Color.White
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .background(Color.Black)
                        .clip(RoundedCornerShape(20.dp))
                ) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.facebook),
                            contentDescription = "facebook",
                            modifier = Modifier.size(20.dp),
                            tint = Color.White
                        )
                    }
                }


            }
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = username.text,
                onValueChange = {
                loginViewModel.setUserName(it) },
                placeholder = {
                              Text(text = "Enter the username")
                },
                modifier = Modifier.fillMaxWidth(),
                isError = username.error !=  null
            )
            if (username.error != "") {
                Text(
                    text = username.error ?: "",
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.End,
                    modifier = Modifier.fillMaxWidth().padding(top = 5.dp)
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            OutlinedTextField(
                value = password.text,
                onValueChange = {
                loginViewModel.setPassWord(it) },
                placeholder = {
                    Text(text = "Enter the password")
                },
                modifier = Modifier.fillMaxWidth(),
                isError = password.error !=  null

            )
            if (username.error != "") {
                Text(
                    text = password.error ?: "",
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.End,
                    modifier = Modifier.fillMaxWidth().padding(top = 5.dp)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 10.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "Quên mật khẩu ?",
                )

            }


            Button(
                onClick = {
                    Log.d("login", "asdasd")
                    viewModel.setStateLogin()
                    loginViewModel.loginUser(onNavigation = {
                        navController.navigate(Screen.BottomBar.Home.route)
                    })

                }
            )
            {

                Text(
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                    text = stringResource(id = R.string.login)
                )
            }
            Row(modifier = Modifier.padding(10.dp)) {
                Text(text = "Bạn chưa có tài khoản ?")
                Text(text = " Đăng kí ngay", style = TextStyle(color = Color.Blue))
            }

        }
    }
}