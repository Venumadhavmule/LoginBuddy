package com.venu.loginbuddy.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.venu.loginbuddy.screens.ForgotPasswordScreen
import com.venu.loginbuddy.screens.HomeScreen
import com.venu.loginbuddy.screens.LoginScreen
import com.venu.loginbuddy.screens.PhoneAuthScreen
import com.venu.loginbuddy.screens.SignUpScreen
import com.venu.loginbuddy.screens.SplashScreen

sealed class Screen(val route: String) {
    object Splash : Screen(route = "splash_screen")
    object Login : Screen("login_screen")
    object Home : Screen("home_screen")
    object Signup : Screen("signup_screen")
    object ForgotPassword : Screen("forgot_password_screen")
    object PhoneAuth : Screen("phone_auth_screen")
}

@Composable
fun AppNavGraph(navController: NavHostController, startDestination: String) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(Screen.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(Screen.Signup.route) {
            SignUpScreen(navController = navController)
        }
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(Screen.ForgotPassword.route) {
            ForgotPasswordScreen(navController = navController)
        }
        composable(route = Screen.PhoneAuth.route) {
            PhoneAuthScreen(navController = navController)
        }
    }
}