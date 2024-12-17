package com.example.agromediator_frontend.view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.compose.rememberNavController
import com.example.agromediator_frontend.model.NavItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {

    val navItemList = listOf(
        NavItem("Beranda", Icons.Default.Home),
        NavItem("Troli", Icons.Default.ShoppingCart),
        NavItem("Profile", Icons.Default.Person),
    )

    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(0xFFD6EFD8),
        bottomBar = {
            NavigationBar (
                containerColor = Color.Gray,
            ) {
                navItemList.forEachIndexed {
                        index, navItem ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                        },
                        icon = {
                            Icon(
                                imageVector = navItem.icon,
                                contentDescription = "Icon",
                                tint = if (selectedIndex == index) Color.Black else Color.LightGray
                            )
                        },
                        label = {
                            Text(
                                navItem.label,
                                color = if (selectedIndex == index) Color.Black else Color.LightGray
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.Black,
                            unselectedIconColor = Color.Gray,
                            selectedTextColor = Color.Black,
                            unselectedTextColor = Color.Gray,
                            indicatorColor = Color.Transparent
                        )
                    )
                }
            }
        }
    ) { paddingValues ->
        ContentScreen(selectedIndex, paddingValues,navController)
    }
}

@Composable
fun ContentScreen(selectedIndex: Int, paddingValues: PaddingValues,navController: NavController) {
    when(selectedIndex) {
        0-> HomePage(paddingValues = paddingValues)
        1-> TroliPage(navController)
        2-> ProfilePage(navController)
    }
}