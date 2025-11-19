package com.quotes.quotesapplication.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.quotes.quotesapplication.presentation.screen.ExploreScreen
import com.quotes.quotesapplication.presentation.screen.HomeScreen
import com.quotes.quotesapplication.presentation.screen.SavedScreen

@Composable
fun AppNavGraph(navHostController: NavHostController, modifier: Modifier) {


    NavHost(navHostController, startDestination = BottomNavItem.home.route,   modifier = modifier) {

        composable(BottomNavItem.home.route) {

            HomeScreen(onNavigateToExplore = { data ->
                // println(data)
                navHostController.navigate(BottomNavItem.explore.route)
            })

        }

        composable(
            BottomNavItem.explore.route

        ) {backStackEntry->
          //  val category= backStackEntry.arguments?.getString("category")
            //println(category)
            ExploreScreen()
        }

        composable(BottomNavItem.saved.route) {
            SavedScreen()
        }
    }

}