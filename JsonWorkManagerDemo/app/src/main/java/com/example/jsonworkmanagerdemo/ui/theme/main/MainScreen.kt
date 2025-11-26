package com.example.jsonworkmanagerdemo.ui.theme.main

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jsonworkmanagerdemo.ui.main.MainViewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel = viewModel()
) {
    val state = viewModel.uiState
    val context = LocalContext.current

    Scaffold { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(onClick = { viewModel.loadUsers(context) }) {
                Text(if (state.isLoading) "Loading..." else "Load User Data")
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (state.isLoading)
                CircularProgressIndicator()

            state.error?.let {
                Text(it, color = Color.Red)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Display list of users
            state.users.forEach { user ->
                Text("Name: ${user.name}")
                Text("Age: ${user.age}")
                Text("City: ${user.city}")
                Spacer(modifier = Modifier.height(12.dp))
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(onClick = { viewModel.startBackgroundWork(context) }) {
                Text("Start Background Work")
            }
        }
    }
}
