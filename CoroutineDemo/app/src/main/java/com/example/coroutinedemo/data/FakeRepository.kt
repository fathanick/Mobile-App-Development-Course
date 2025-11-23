package com.example.coroutinedemo.data
import kotlinx.coroutines.delay

class FakeRepository {
    // suspend: can be called from a coroutine
    suspend fun fetchWelcomeMessage(): String {
        // Simulate a 2-second "network" delay
        delay(2000L)
        return "Hello from coroutine! Data loaded successfully."
    }
}