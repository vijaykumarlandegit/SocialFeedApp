package com.practice.socialfeed.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LoginViewModel : ViewModel() {

    private val _username = MutableStateFlow("")
    val username: StateFlow<String> = _username

    fun onUsernameChange(newValue: String) {
        _username.value = newValue
    }

    fun canLogin(): Boolean = _username.value.isNotBlank()
}