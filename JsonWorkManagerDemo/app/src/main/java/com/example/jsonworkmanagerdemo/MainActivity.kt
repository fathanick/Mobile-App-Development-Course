package com.example.jsonworkmanagerdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.jsonworkmanagerdemo.ui.theme.JsonWorkManagerDemoTheme
import com.example.jsonworkmanagerdemo.ui.theme.main.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            setContent {
                JsonWorkManagerDemoTheme {
                    MainScreen()
                }
            }
        }
    }
}