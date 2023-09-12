package com.tsutsurin.reviewsproject.ui.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tsutsurin.authtorization.AuthorizationRoute

@Composable
fun MainNavigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = Screens.AuthorizationScreen.route) {
        composable(Screens.AuthorizationScreen.route) {
            AuthorizationRoute(onGoBack = { navController.popBackStack() })
        }
    }
}

sealed class Screens(val route: String) {
    object AuthorizationScreen : Screens("authorization")
}