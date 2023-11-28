package com.example.myapplication.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ImageBox
import com.example.myapplication.ProfileBottomCard
import com.example.myapplication.ProfileTopCard
import com.example.myapplication.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(){
    Scaffold(modifier = Modifier
        .fillMaxSize()
        .padding(start = 80.dp)
    ) {
        Column {
            ProfileTopCard()
            ProfileBottomCard()
            LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 128.dp)){
                items(20){
                    ImageBox(resource_id = R.drawable.temp_logo, width = 25.dp, height = 25.dp)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview(){
    ProfileScreen()
}