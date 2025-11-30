package com.example.apicomposedemo.ui
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun PostScreen(viewModel: PostViewModel = viewModel()) {

    val posts = viewModel.posts
    val loading = viewModel.isLoading

    Box(modifier = Modifier.fillMaxSize().padding(16.dp)) {

        if (loading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else {
            LazyColumn {
                items(posts) { post ->
                    Text(text = "- ${post.title}")
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

