package com.venu.loginbuddy

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AuthViewModel : ViewModel() {
    private val auth = FirebaseAuth.getInstance()
    private val _isUserAuthenticated = MutableStateFlow(false)

    val isUserAuthenticated: StateFlow<Boolean> = _isUserAuthenticated

    init {
        _isUserAuthenticated.value = auth.currentUser != null
    }
}