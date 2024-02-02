package com.zehcort.weatherx.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.zehcort.weatherx.views.composables.screens.ForecastScreen
import com.zehcort.weatherx.views.composables.screens.HomeScreen

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Route.Home.route
    ) {
        composable(Route.Home.route) {
            HomeScreen()
        }
        composable(Route.Forecast.route) {
            ForecastScreen()
        }
    }
}