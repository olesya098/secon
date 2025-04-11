package com.hfad.energon
sealed class Screen(var route: String) {
    object SplashScreen : Screen("SplashScreen")
    object SignInScreen : Screen("SignInScreen")
    object SigUpScreen : Screen("SigUpScreen")
    object SigUpScreen2 : Screen("SigUpScreen2")
    object Akts : Screen("Akts")
}
