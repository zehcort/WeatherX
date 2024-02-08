package com.zehcort.weatherx.navigation

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.zehcort.weatherx.utils.LocationData
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
        composable(route = Route.Home.route,
            deepLinks = listOf(
                navDeepLink {
                    uriPattern = "app://weatherx/{latitude}/{longitude}"
                    action = Intent.ACTION_VIEW
                }
            ),
            arguments = listOf(
                navArgument("latitude") {
                    type = NavType.StringType
                    defaultValue = ""
                },
                navArgument("longitude") {
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        ) { backStackEntry ->
            HomeScreen(
                locationData = LocationData(
                    latitude = backStackEntry.arguments?.getString("latitude") ?: "",
                    longitude = backStackEntry.arguments?.getString("longitude") ?: ""
                )
            )
        }
        composable(route = Route.Forecast.route) {
            ForecastScreen()
        }
    }
}