package com.example.basicnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.basicnavigation.ui.theme.BasicNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BasicNavigationTheme {
                    BasicNavigationApp()
            }
        }
    }
}

@Composable
fun BasicNavigationApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.Home.route
    ){
        // Home Screen
        composable(Routes.Home.route) {
            HomeScreen(navController)
        }

        // Profile Screen
        composable(Routes.Profile.route) {
            ProfileScreen(navController)
        }

        // Detail Screen
        composable(Routes.Detail.route) {
            DetailScreen(navController)
        }
    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BasicNavigationTheme {
        BasicNavigationApp()
    }
}