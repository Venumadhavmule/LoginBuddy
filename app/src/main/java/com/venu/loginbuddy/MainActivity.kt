package com.venu.loginbuddy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.google.firebase.FirebaseApp
import com.venu.loginbuddy.navigation.AppNavGraph
import com.venu.loginbuddy.navigation.Screen
import com.venu.loginbuddy.ui.theme.LoginBuddyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)

        setContent {
            LoginBuddyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val authViewModel: AuthViewModel = viewModel()
                    val isUserAuthenticated by authViewModel.isUserAuthenticated.collectAsState()
                    val navController = rememberNavController()

                    val startDestination = if (isUserAuthenticated) {
                        Screen.Home.route
                    } else {
                        Screen.Login.route
                    }
                    AppNavGraph(navController = navController, startDestination)
                }
            }
        }
    }
}