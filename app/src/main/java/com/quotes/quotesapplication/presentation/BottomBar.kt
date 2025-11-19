package com.quotes.quotesapplication.presentation

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.quotes.quotesapplication.presentation.screen.HomeScreen

@Composable
fun BottomBar(navHostController: NavHostController) {
    val items = listOf(BottomNavItem.home, BottomNavItem.explore, BottomNavItem.saved)

    NavigationBar(
        containerColor = Color.White
    ) {
        val navBackStackEntry = navHostController.currentBackStackEntryAsState()

        val currentRoute = navBackStackEntry.value?.destination?.route
        items.forEach { item ->

            val selected = currentRoute == item.route

            NavigationBarItem(
                selected = selected,
                onClick = {
                    if (!selected) {
                        navHostController.navigate(item.route) {
                            popUpTo(navHostController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    }
                },
                label = { Text(item.title) },   // ❌ no color override
                icon = { Text("⬤") },           // ❌ no color override
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Blue,
                    selectedTextColor = Color.Blue,
                    indicatorColor = Color(0x220000FF),
                    unselectedIconColor = Color.Gray,
                    unselectedTextColor = Color.Gray
                )
            )
        }
    }
}
