package com.quotes.quotesapplication.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.quotes.quotesapplication.presentation.screen.ExploreScreen
import com.quotes.quotesapplication.presentation.screen.HomeScreen
import com.quotes.quotesapplication.presentation.screen.SavedScreen

@Composable
fun AppNavGraph(navHostController: NavHostController, modifier: Modifier) {


    NavHost(navHostController, startDestination = BottomNavItem.home.route,   modifier = modifier) {

        composable(BottomNavItem.home.route) {

            HomeScreen(onNavigateToExplore = { categoryId,type ->


                val route = buildString {
                    append(BottomNavItem.explore.route)
                    if (categoryId != null || type != null) {
                        append("?categoryId=${categoryId ?: ""}")
                        append("&type=${type ?: ""}")
                    }
                }
                println("Data On Rount"+"-"+route)
                navHostController.navigate(route)
            })

        }

        composable(
            BottomNavItem.explore.route+"?categoryId={categoryId}&type={type}",
            arguments =  listOf(
                navArgument("categoryId") {
                    nullable = true
                    defaultValue = null
                },
                navArgument("type") {
                    nullable = true
                    defaultValue = null
                }
            )

        ) {backStackEntry->
            val category= backStackEntry.arguments?.getString("categoryId")
            val type = backStackEntry.arguments?.getString("type")

            println("Data On Recive"+"-"+category+" "+type)
            ExploreScreen(category,type)
        }

        composable(BottomNavItem.saved.route) {
            SavedScreen()
        }
    }

}