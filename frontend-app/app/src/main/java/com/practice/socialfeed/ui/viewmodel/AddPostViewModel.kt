package com.practice.socialfeed.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practice.socialfeed.data.model.AddPostUiState
import com.practice.socialfeed.data.remote.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddPostViewModel @Inject constructor(
    private val repository: PostRepository,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _uiState = MutableStateFlow(AddPostUiState())
    val uiState: StateFlow<AddPostUiState> = _uiState

    fun submitPost(content: String) {
        if (content.isBlank()) return

        viewModelScope.launch(ioDispatcher) {
            _uiState.value = AddPostUiState(isLoading = true)
            try {
                repository.addPost(content)
                _uiState.value = AddPostUiState(
                    isLoading = false,
                    isSuccess = true
                )
            } catch (e: Exception) {
                _uiState.value = AddPostUiState(
                    isLoading = false,
                    errorMessage = e.message ?: "Something went wrong"
                )
            }
        }
    }

    fun clearSuccessFlag() {
        _uiState.value = _uiState.value.copy(isSuccess = false)
    }
}