package com.venu.loginbuddy.navigation

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

sealed class Screen(val route: String) {
    object Login : Screen("login_screen")
    object Home : Screen("home_screen")
    object Signup : Screen("signup_screen")
    object ForgotPassword : Screen("forgot_password_screen")
    object PhoneAuth : Screen("phone_auth_screen")
}

@Composable
fun AppNavGraph(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route,
        modifier = androidx.compose.ui.Modifier.padding(paddingValues)
    ) {
        composable(Screen.Login.route) {
            // TODO: Replace with your LoginScreen()
        }
        composable(Screen.Home.route) {
            // TODO: Replace with your HomeScreen()
        }
        composable(Screen.Signup.route) {
            // TODO: Replace with your SignupScreen()
        }
        composable(Screen.ForgotPassword.route) {
            // TODO: Replace with your ForgotPasswordScreen()
        }
        composable(Screen.PhoneAuth.route) {
            // TODO: Replace with your PhoneAuthScreen()
        }
    }
}
