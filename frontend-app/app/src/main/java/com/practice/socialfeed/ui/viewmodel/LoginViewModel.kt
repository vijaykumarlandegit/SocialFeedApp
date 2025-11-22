package com.practice.socialfeed.ui.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {

    private val _username = MutableStateFlow("")
    val username: StateFlow<String> = _username

    fun onUsernameChange(newValue: String) {
        _username.value = newValue
    }

    fun canLogin(): Boolean = _username.value.isNotBlank()
}