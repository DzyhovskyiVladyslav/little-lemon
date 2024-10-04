package com.vladdzyga.littlelemon

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

/**
 * @author VladyslavDzyhovskyi
 * Created 04-Oct-24 at 12:15
 */

@Composable
fun Navigation(navController: NavHostController, sharedPreferences: SharedPreferences) {
    val startDestination = if (sharedPreferences.getBoolean("logged", false)) {
        Home.route
    } else {
        Onboarding.route
    }

    NavHost(navController = navController, startDestination = startDestination) {
        composable(Onboarding.route) {
            Onboarding(sharedPreferences)
        }
        composable(Home.route) {
            Home(navController)
        }
        composable(Profile.route) {
            Profile(sharedPreferences)
        }
    }
}