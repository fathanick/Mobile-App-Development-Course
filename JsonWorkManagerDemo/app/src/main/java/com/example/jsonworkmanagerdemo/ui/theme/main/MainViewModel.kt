package com.example.jsonworkmanagerdemo.ui.main

import android.content.Context
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.jsonworkmanagerdemo.data.FakeRepository
import com.example.jsonworkmanagerdemo.data.UserData
import com.example.jsonworkmanagerdemo.work.MyWorker
import kotlinx.coroutines.launch

data class MainUiState(
    val users: List<UserData> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

class MainViewModel(
    private val repository: FakeRepository = FakeRepository()
) : ViewModel() {

    var uiState by mutableStateOf(MainUiState())
        private set

    fun loadUsers(context: Context) {
        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true, error = null)

            try {
                val list = repository.fetchUsers(context)
                uiState = uiState.copy(users = list, isLoading = false)
            } catch (e: Exception) {
                uiState = uiState.copy(error = "Unable to load data.", isLoading = false)
            }
        }
    }

    fun startBackgroundWork(context: Context) {
        val request = OneTimeWorkRequestBuilder<MyWorker>().build()
        WorkManager.getInstance(context).enqueue(request)
    }
}
