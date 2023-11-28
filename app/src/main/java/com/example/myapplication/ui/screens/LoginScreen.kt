package com.example.myapplication.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.BackgroundShape
import com.example.myapplication.ButtonComponent
import com.example.myapplication.Screen
import com.example.myapplication.TextComponent
import com.example.myapplication.TextFieldComponent

@Composable
fun LoginScreen(navController: NavController){
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(0.dp,18.dp,0.dp,0.dp)) {
            BackgroundShape(topStart = 30f, topEnd = 90f, bottomEnd = 320f, bottomStart = 30f)
        }
        Column(modifier = Modifier
            .padding(18.dp)
        ) {
            TextComponent(textValue = "Welcome Back !  \uD83D\uDC4B ",
                textSize = 24.sp,
                fontWeight = FontWeight.ExtraBold)
            Spacer(Modifier.size(15.dp))
            TextComponent(textValue = "Log In", textSize = 30.sp, fontWeight = FontWeight.Medium)
            Spacer(modifier = Modifier.size(24.dp))
        }
        Column(modifier = Modifier.padding(18.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center){
            TextFieldComponent(text = "Username", placeholder = "Enter your username")
            Spacer(Modifier.size(15.dp))
            /////otp
            Spacer(modifier = Modifier.size(24.dp))
            ButtonComponent(textValue = "Login",{
                navController.navigate(Screen.Main.route)
            })
            Spacer(Modifier.size(35.dp))
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                TextComponent(
                    textValue = "Don't have a Account?",
                    textSize = 18.sp,
                    fontWeight = FontWeight.Light
                )
                TextComponent(textValue = "   Sign Up", textSize = 18.sp, fontWeight = FontWeight.Medium)
            }
        }

    }
}

@Preview
@Composable
fun LoginScreenPreview(){
    LoginScreen(rememberNavController())
}