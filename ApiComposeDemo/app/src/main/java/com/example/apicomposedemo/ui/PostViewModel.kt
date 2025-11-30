package com.example.apicomposedemo.ui
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apicomposedemo.data.RetrofitClient
import com.example.apicomposedemo.model.Post
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {

    var posts by mutableStateOf<List<Post>>(emptyList())
        private set

    var isLoading by mutableStateOf(true)
        private set

    init {
        loadPosts()
    }

    private fun loadPosts() {
        viewModelScope.launch {
            posts = RetrofitClient.api.getPosts()
            isLoading = false
        }
    }
}
