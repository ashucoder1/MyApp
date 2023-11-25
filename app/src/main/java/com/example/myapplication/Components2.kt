package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.offset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class NavigationItem(
    val title: String,
    val unselectedIcon: ImageVector,
    val selectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)

val items = listOf(
    NavigationItem(
        title = "Home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        hasNews = false,
    ),
    NavigationItem(
        title = "Chat",
        selectedIcon = Icons.Filled.Email,
        unselectedIcon = Icons.Outlined.Email,
        hasNews = false,
        badgeCount = 45
    ),
    NavigationItem(
        title = "Settings",
        selectedIcon = Icons.Filled.Settings,
        unselectedIcon = Icons.Outlined.Settings,
        hasNews = true,
    ),
)

@Composable
fun NavigationSideBar(
    items: List<NavigationItem>,
    selectedItemIndex:Int,
    onNavigate:(Int)->Unit
){
    NavigationRail(
        header = {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
        }

    }, modifier = Modifier.background(MaterialTheme.colorScheme.inverseOnSurface)
            .offset(x=(-1).dp)
    ) {
        Column(modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Bottom)) {
            items.forEachIndexed { index, item ->
                NavigationRailItem(selected = selectedItemIndex==index,
                    onClick = {
                        onNavigate(index)
                    },
                    icon = {
                        NavigationIcon(item = item, selected = selectedItemIndex==index)
                    },
                    label = {
                        Text(text = item.title)
                    })
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationIcon(
    item:NavigationItem,
    selected:Boolean
){
    BadgedBox(badge = {
        if (item.badgeCount!=null){
            Badge {
                Text(text = item.badgeCount.toString())
            }
        }else if(item.hasNews){
            Badge()
        }
    }) {
        Icon(imageVector = if(selected)item.selectedIcon else item.unselectedIcon,
            contentDescription = item.title)
    }
}

@Preview()
@Composable
fun NavigtionSideBarPreview(){
    NavigationSideBar(items = items, selectedItemIndex = 1, onNavigate = {})
}

