package com.example.myapplication.ui.screens

import androidx.compose.foundation.layout.Column
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
import com.example.myapplication.BackgroundShape
import com.example.myapplication.ButtonComponent
import com.example.myapplication.TextComponent
import com.example.myapplication.TextFieldComponent

@Composable
fun SignUpScreen(){
    Surface(modifier = Modifier.fillMaxSize()){
        //column or row padding should be 18dp
        Column(modifier = Modifier.padding(0.dp,18.dp,0.dp,0.dp)) {
            BackgroundShape(topStart = 30f, topEnd = 90f, bottomEnd = 320f, bottomStart = 30f)
        }
        Column {
            Column(modifier = Modifier
                .padding(18.dp)
            ) {
                TextComponent(textValue = "Hello!", textSize = 24.sp, fontWeight = FontWeight.ExtraBold)
                Spacer(Modifier.size(15.dp))
                TextComponent(textValue = "Sign Up", textSize = 30.sp, fontWeight = FontWeight.Medium)
                Spacer(modifier = Modifier.size(24.dp))
            }
            Column(modifier = Modifier.padding(18.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextFieldComponent("User Name")
                Spacer(Modifier.size(15.dp))
                TextFieldComponent("Email")
                Spacer(Modifier.size(15.dp))
                TextFieldComponent("Phone No")
                Spacer(Modifier.size(15.dp))
                ///OTP Field Here
                Spacer(Modifier.size(15.dp))
                ButtonComponent("Sign Up")
            }
        }
    }
}

@Preview
@Composable
fun SignUpScreenPreview(){
    SignUpScreen()
}