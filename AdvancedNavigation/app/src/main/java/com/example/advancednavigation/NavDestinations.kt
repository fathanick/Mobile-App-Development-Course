package com.example.advancednavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavDestinations(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : NavDestinations("home_route", "Home", Icons.Default.Home)
    object Search : NavDestinations("search_route", "Search", Icons.Default.Menu)
    object Profile : NavDestinations("profile_route", "Profile", Icons.Default.Settings)
    // Add other destinations for your drawer and tabs
    object DrawerItem1 : NavDestinations("drawer_item1", "Drawer Item 1", Icons.Default.Home)
    object DrawerItem2 : NavDestinations("drawer_item2", "Drawer Item 2", Icons.Default.Settings)
    object Tab1 : NavDestinations("tab1_route", "Tab 1", Icons.Default.Home)
    object Tab2 : NavDestinations("tab2_route", "Tab 2", Icons.Default.Menu)
}