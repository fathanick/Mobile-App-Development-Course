package com.example.navigationwitharguments

import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
data class OrderDetails(
    val productName: String,
    val quantity: Int
)
