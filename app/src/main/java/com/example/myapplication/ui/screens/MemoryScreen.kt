package com.example.myapplication.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ImageBox
import com.example.myapplication.MemoryComponent
import com.example.myapplication.R
import com.example.myapplication.RoomCard
import com.example.myapplication.TextComponent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MemoryScreen(){
    Scaffold(modifier = Modifier
        .fillMaxSize()
        .padding(start = 80.dp)
    ) {
        Column {
            Row(modifier= Modifier
                .fillMaxWidth()
                .padding(18.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically) {
                    ImageBox(resource_id = R.drawable.temp_logo, width =50.dp , height = 50.dp)
                    Image(imageVector = Icons.Default.Refresh, contentDescription = "new_memory")
            }
            MemoryComponent()
            //Spacer(modifier = Modifier.size(4.dp))
            Row(modifier= Modifier
                .fillMaxWidth()
                .padding(18.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {
                TextComponent(textValue = "Rooms", textSize = 18.sp, fontWeight = FontWeight.Bold)
                Image(imageVector = Icons.Default.Add, contentDescription = "Add_room")
            }
            //Lazy Grid Starts
            LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 128.dp),
                contentPadding = PaddingValues(8.dp)
            ){
                items(20){
                    RoomCard()
                }
            }



        }
    }
}

@Preview(showBackground = true)
@Composable
fun MemoryScreenPreview(){
    MemoryScreen()
}