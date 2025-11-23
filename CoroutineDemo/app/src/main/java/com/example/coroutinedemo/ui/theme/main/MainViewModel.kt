package com.example.coroutinedemo.ui.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coroutinedemo.data.FakeRepository
import kotlinx.coroutines.launch

// UI state holder
data class MainUiState(
    val message: String = "Tap the button to load a message.",
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)

class MainViewModel(
    private val repository: FakeRepository = FakeRepository()
) : ViewModel() {

    // Compose state exposed to UI
    var uiState by mutableStateOf(MainUiState())
        private set

    fun loadMessage() {
        // Launch coroutine in ViewModel scope
        viewModelScope.launch {
            // Set loading state
            uiState = uiState.copy(
                isLoading = true,
                errorMessage = null
            )

            try {
                // Call suspend function
                val result = repository.fetchWelcomeMessage()

                // Update UI state with result
                uiState = uiState.copy(
                    message = result,
                    isLoading = false
                )
            } catch (e: Exception) {
                // Handle error
                uiState = uiState.copy(
                    errorMessage = "Something went wrong. Please try again.",
                    isLoading = false
                )
            }
        }
    }
}
