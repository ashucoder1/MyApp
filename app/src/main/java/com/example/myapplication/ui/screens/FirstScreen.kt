package com.example.myapplication.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ButtonComponent
import com.example.myapplication.ImageBox
import com.example.myapplication.R
import com.example.myapplication.Screen

@Composable
fun FirstScreen(navController: NavController){
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(18.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            ImageBox(resource_id =  R.drawable.temp_logo, width = 100.dp, height = 100.dp)
            Spacer(modifier = Modifier.size(200.dp))
            ButtonComponent(textValue = "Sign Up") {
                navController.navigate(Screen.SignUp.route)
            }
            Spacer(modifier = Modifier.size(50.dp))
            ButtonComponent(textValue = "Login") {
                navController.navigate(Screen.Login.route)
            }
        }

    }

}


@Preview
@Composable
fun FirstScreenPreview(){
    FirstScreen(navController = rememberNavController())
}