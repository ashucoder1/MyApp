package com.example.myapplication.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.NavigationSideBar
import com.example.myapplication.items

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController){
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

    Surface(modifier = Modifier
        .fillMaxSize()) {
        MemoryScreen()
    }
    //Rails
    NavigationSideBar(items = items,
        selectedItemIndex = selectedItemIndex,
        onNavigate = {selectedItemIndex=it})
}

@Preview
@Composable
fun MainScreenPreview(){
    MainScreen(rememberNavController())
}