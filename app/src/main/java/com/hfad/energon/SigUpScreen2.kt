package com.hfad.energon

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.hfad.energon.ui.theme.buttonColor
import com.hfad.energon.ui.theme.lable
import com.hfad.energon.ui.theme.textField

@Composable
fun SigUpScreen2(navController: NavController) {
    var email by remember { mutableStateOf("") }
    val fredo = FontFamily(Font(com.hfad.energon.R.font.fredokabold))
    val fredoRegular = FontFamily(Font(com.hfad.energon.R.font.fredokaregular))
    var showError by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    Scaffold(
        bottomBar = {
            Column(
                modifier = Modifier
                    .background(Color.White),

                ) {
                // Создание пользователя

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate(Screen.SignInScreen.route)
                        }
                        .background(Color.White)
                        .padding(bottom = 70.dp, start = 15.dp, end = 15.dp, top = 15.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Есть учётная запись?",
                        color = Color.Gray,
                        fontSize = 17.sp
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Войти",
                        color = Color.Black,
                        fontSize = 17.sp,
                        modifier = Modifier
                    )
                }
            }
        }

    ) { paddingValues ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp, end = 16.dp, top = 20.dp)
            ) {
                Box(
                    modifier = Modifier.background(
                        color = textField,
                        shape = CircleShape
                    )
                        .size(45.dp)
                        .clickable {
                            navController.navigate(Screen.SigUpScreen.route)
                        },
                    contentAlignment = Alignment.Center
                ){
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = null,
                        tint = Color.Black
                    )
                }
                // Привет!
                Text(
                    text = "Регистрация",
                    fontSize = 30.sp,
                    fontFamily = fredoRegular,
                    fontWeight = FontWeight.Bold,

                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 8.dp)
                )

                // Подзаголовок
                Text(
                    text = "Введите Свои Данные Для Регистрации",
                    fontSize = 16.sp,
                    color = Color.Gray,
                    fontFamily = fredoRegular,

                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 16.dp, bottom = 24.dp)
                        .width(271.dp)
                )

                // Email Label
                Text(
                    text = "Email",
                    fontFamily = fredoRegular,

                    fontSize = 18.sp,
                    modifier = Modifier.padding(bottom = 12.dp, top = 26.dp)
                )
                Column(

                ) {
                    TextField(
                        value = email,
                        onValueChange = { newText ->
                            email = newText
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(54.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = textField,
                            unfocusedContainerColor = textField,
                            disabledContainerColor = Color(0xFFE0E0E0),
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedLabelColor = lable,
                            unfocusedLabelColor = lable,
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.Gray
                        ),
                        placeholder = {
                            Text(
                                "xyz@gmail.com",
                                color = Color.Gray,
                                fontSize = 15.sp
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                    )
                }
                // Пароль Label
                Text(
                    text = "Пароль",
                    fontSize = 18.sp,
                    fontFamily = fredoRegular,

                    modifier = Modifier.padding(top = 26.dp, bottom = 12.dp)
                )

                // Пароль Input
                TextField(
                    value = password, // Используем переменную состояния
                    onValueChange = { newText -> // Обновляем состояние при вводе
                        password = newText
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(54.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = textField,
                        unfocusedContainerColor = textField,
                        disabledContainerColor = Color(0xFFE0E0E0),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedLabelColor = Color.Gray,
                        unfocusedLabelColor = Color.Gray,
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Gray
                    ),
                    placeholder = {
                        Text(
                            "Введите пароль",
                            color = lable,
                            fontSize = 15.sp
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(
                                painter = if (passwordVisible) painterResource(id = com.hfad.energon.R.drawable.eyepocaz) else painterResource(
                                    id = R.drawable.eye
                                ),
                                tint = lable,
                                contentDescription = if (passwordVisible) "Скрыть пароль" else "Показать пароль",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                )
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = buttonColor
                    ),
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 25.dp,)
                        .height(56.dp)
                ) {
                    Text(
                        text = "Войти",
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                }


// Проверяем, требуется ли показать диалоговое окно с ошибкой
                if (showError) {
                    AlertDialog(
                        // Действие при закрытии диалогового окна
                        onDismissRequest = {
                            showError = false
                        }, // Устанавливаем showError в false при закрытии окна
                        title = { Text("Ошибка") }, // Заголовок диалогового окна
                        text = { Text(errorMessage) }, // Текст сообщения об ошибке
                        confirmButton = {
                            // Кнопка для подтверждения в диалоговом окне
                            TextButton(onClick = { showError = false }) {
                                Text("OK") // Текст кнопки - "OK"
                            }
                        }
                    )
                }


            }
        }
    }
}


@PreviewScreenSizes
@Composable
fun SigUpScreen2Preview() {
    SigUpScreen2(rememberNavController())

}