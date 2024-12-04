package com.example.agromediator_frontend

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.agromediator_frontend.model.Routes
import com.example.agromediator_frontend.ui.theme.Agromediator_frontendTheme
import com.example.agromediator_frontend.view.EditProfileScreen
import com.example.agromediator_frontend.view.ForgetpasswordScreen
import com.example.agromediator_frontend.view.HomeScreen
import com.example.agromediator_frontend.view.LoginScreen
import com.example.agromediator_frontend.view.ProfilePage
import com.example.agromediator_frontend.view.RegisterScreen
import com.example.agromediator_frontend.view.SplashScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Agromediator_frontendTheme {
                AgromediatorApp()
            }
        }
    }
}

@Composable
fun AgromediatorApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.splash,
        builder = {
            composable(Routes.splash) {
                SplashScreen {
                    navController.navigate(Routes.login)
                }
            }
            composable(Routes.login) {
                LoginScreen(navController)
            }
            composable(Routes.register) {
                RegisterScreen(navController)
            }
            composable(Routes.home) {
                HomeScreen(navController)
            }
            composable(Routes.forget){
                ForgetpasswordScreen(navController)
            }
            composable(Routes.Editprofile){
                EditProfileScreen(navController)
            }
            composable(Routes.Profile){
                ProfilePage(navController)
            }
        }
    )
}