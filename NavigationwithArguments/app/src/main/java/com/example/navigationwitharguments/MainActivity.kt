package com.example.navigationwitharguments

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.navigationwitharguments.ui.theme.NavigationWithArgumentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationWithArgumentsTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Home
    ) {
        composable<Home> {
            HomeScreen(
                onNavigateToDetails = { productName, quantity ->
                    navController.navigate(OrderDetails(productName, quantity))
                }
            )
        }

        composable<OrderDetails> {
            val args = it.toRoute<OrderDetails>()
            OrderDetailsScreen(
                navController = navController,
                productName = args.productName,
                quantity = args.quantity
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NavigationWithArgumentsTheme {
        MainScreen()
    }
}