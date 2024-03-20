package com.example.quizletapp2.presentaition.signin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.quizletapp2.R
import com.example.quizletapp2.presentaition.Component.LoadingBtnDot.LoadingButton
import com.example.quizletapp2.presentaition.Screen


@Composable
fun SignInScreen (
    navController: NavController,
    signInViewModel: SignInViewModel = hiltViewModel()

) {
    val name = signInViewModel.nameState.value
    val email = signInViewModel.emailState.value
    val username = signInViewModel.usernameState.value
    val password = signInViewModel.passwordState.value
    val scaffoldState = rememberScaffoldState()
    val rePassword = remember {
        mutableStateOf("")
    }

    val loadingState = signInViewModel.loginState.value
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
                text = "Đăng Kí",
                style = TextStyle(fontSize = 35.sp, fontWeight = FontWeight.ExtraBold)
            )

            Spacer(modifier = Modifier.height(30.dp))
            OutlinedTextField(
                value = name.text,
                onValueChange = {
                                signInViewModel.setName(it)
                },
                placeholder = {
                    Text(text = "Nhập họ và tên")
                },
                modifier = Modifier.fillMaxWidth(),
                isError = false
            )
            if (name.error != "") {
                Text(
                    text = name.error ?: "",
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            OutlinedTextField(
                value = username.text,
                onValueChange = {
                    signInViewModel.setUsername(it)

                },
                placeholder = {
                    Text(text = "Nhập tên tài khoản")
                },
                modifier = Modifier.fillMaxWidth(),
                isError = false

            )
            if (username.error != "") {
                Text(
                    text = username.error ?: "",
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                )
            }
            Spacer(modifier = Modifier.height(15.dp))

            OutlinedTextField(
                value = email.text,
                onValueChange = {
                    signInViewModel.setEmail(it)

                },
                placeholder = {
                    Text(text = "Nhập địa chỉ email")
                },
                modifier = Modifier.fillMaxWidth(),
                isError = false

            )
            if (email.error != "") {
                Text(
                    text = email.error ?: "",
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                )
            }
            Spacer(modifier = Modifier.height(15.dp))

            OutlinedTextField(
                value = password.text,
                onValueChange = {
                    signInViewModel.setPassword(it)

                },
                placeholder = {
                    Text(text = "Nhập vào mật khẩu")
                },
                modifier = Modifier.fillMaxWidth(),
                isError = false

            )
            if (password.error != "") {
                Text(
                    text = password.error ?: "",
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                )
            }
            Spacer(modifier = Modifier.height(15.dp))

            OutlinedTextField(
                value = rePassword.value,
                onValueChange = {
                    rePassword.value = it
                },
                placeholder = {
                    Text(text = "Nhập lại mật khẩu")
                },
                modifier = Modifier.fillMaxWidth(),
                isError = false

            )
            if (rePassword.value != password.text) {
                Text(
                    text = "Mật khẩu không trùng khớp",
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                )
            }

            LoadingButton(
                modifier = Modifier.padding(top = 20.dp),
                onClick = {
                    signInViewModel.singInUser(onNavigation = {
                        navController.navigate(Screen.ModalBottom.Login.route)
                    })
                },
                loading = loadingState.isLoading
            ) {
                Text(text = stringResource(id = R.string.login))

            }


            Row(modifier = Modifier.padding(10.dp)) {
                Text(text = "Bạn đã có tài khoản ?")
                Text(text = " Đăng nhập ngay!", style = TextStyle(color = Color.Blue))
            }


        }
    }


}