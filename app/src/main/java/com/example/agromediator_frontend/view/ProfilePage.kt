package com.example.agromediator_frontend.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ProfilePage() {

    Scaffold (
        topBar = {
            TopAppBar (
                backgroundColor = Color(0xFF80AF81),
                title = {
                    Text("Profile Page")
                },
                modifier = Modifier.statusBarsPadding()
            )
        },
        modifier = Modifier.fillMaxSize()
    ){
            paddingValues -> ProfileContentScreen(paddingValues)
    }
}

@Composable
fun ProfileContentScreen(paddingValues: PaddingValues) {

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
    ) {
        Text("Profile Content")
        Button(
            modifier = Modifier.height(50.dp).width(250.dp),
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF1A5319)
            ),
        ) {
            Text("Keluar", fontSize = 20.sp)
        }
    }
}
