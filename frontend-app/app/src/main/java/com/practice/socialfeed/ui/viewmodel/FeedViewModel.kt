package com.practice.socialfeed.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practice.socialfeed.data.model.FeedUiState
import com.practice.socialfeed.data.remote.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val repository: PostRepository,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _uiState = MutableStateFlow(FeedUiState())
    val uiState: StateFlow<FeedUiState> = _uiState

    fun loadPosts() {
        viewModelScope.launch(ioDispatcher) {
            _uiState.value = _uiState.value.copy(
                isLoading = true,
                errorMessage = null
            )
            try {
                val posts = repository.getPosts()
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    posts = posts
                )
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    errorMessage = e.message ?: "Something went wrong"
                )
            }
        }
    }
}