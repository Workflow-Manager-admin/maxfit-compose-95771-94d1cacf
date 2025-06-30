package com.example.androidjetpackcomposeui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidjetpackcomposeui.screens.DashboardScreen
import com.example.androidjetpackcomposeui.screens.WelcomeScreen
import com.example.androidjetpackcomposeui.screens.WorkoutDetailsScreen

// PUBLIC_INTERFACE
@Composable
fun MaxFitNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome") { WelcomeScreen(navController) }
        composable("dashboard") { DashboardScreen(navController) }
        composable("workout_details") { WorkoutDetailsScreen(navController) }
    }
}
