package com.hfad.energon

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import okhttp3.Route


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigatia() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {
        composable(Screen.SplashScreen.route){
            SplashScreen(navController)
        }
        composable(Screen.SignInScreen.route){
            SignInScreen(navController)
        }
        composable(Screen.SigUpScreen.route){
            SigUpScreen(navController)
        }
        composable(Screen.SigUpScreen2.route){
            SigUpScreen2(navController)
        }
        composable(Screen.Akts.route){
            Akts(navController)
        }
        composable(Screen.SigUpScreenSecond.route){
            SigUpScreenSecond(navController)
        }

    }
}