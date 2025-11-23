package com.example.coroutinedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.coroutinedemo.ui.theme.main.MainScreen
import com.example.coroutinedemo.ui.theme.CoroutineDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoroutineDemoTheme {
                MainScreen()
            }
        }
    }
}