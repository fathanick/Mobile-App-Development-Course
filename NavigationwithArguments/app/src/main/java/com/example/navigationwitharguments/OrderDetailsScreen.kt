package com.example.navigationwitharguments

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun OrderDetailsScreen(navController: NavController, productName: String, quantity: Int) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Product Name: $productName")
        Spacer(modifier = Modifier.height(8.dp))
        Text("Quantity: $quantity")

        Button(onClick = { navController.popBackStack() }) {
            Text("Go Back")
        }
    }
}
