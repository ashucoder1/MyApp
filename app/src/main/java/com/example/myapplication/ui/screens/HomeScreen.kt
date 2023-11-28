package com.example.myapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.FactsComposable
import com.example.myapplication.TextComponent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){
    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column {
            Row(modifier = Modifier
                .padding(start = 81.dp, top = 18.dp, end = 8.dp, bottom = 18.dp)
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
                ) {
                TextComponent(textValue = "Chats", textSize = 24.sp, fontWeight = FontWeight.Medium,)
                Spacer(modifier = Modifier.width(150.dp))
                Image(imageVector = Icons.Default.Search, contentDescription ="Search" )
                Spacer(modifier = Modifier.width(18.dp))
                Image(imageVector = Icons.Default.Add, contentDescription ="Add" )
            }
            LazyColumn(modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(
                    start = 80.dp)){
                items(20){
                    FactsComposable(value = "Item$it")
                }
            }
            }

    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}