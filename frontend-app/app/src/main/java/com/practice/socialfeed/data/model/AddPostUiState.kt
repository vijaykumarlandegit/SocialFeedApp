package com.practice.socialfeed.data.model

data class AddPostUiState(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val errorMessage: String? = null
)