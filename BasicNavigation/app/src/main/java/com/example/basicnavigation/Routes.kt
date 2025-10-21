package com.example.basicnavigation

sealed class Routes(val route: String) {
    object Home : Routes("home")
    object Profile : Routes("profile")
    object Detail: Routes("details")
}