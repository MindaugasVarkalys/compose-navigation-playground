package com.example.myapplication.ui.routes

import ConnectionSuccessful
import Home
import Login
import Mfa
import Profile
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun AppRoutes() {
    val controller = rememberNavController()

    fun openConnectionFlow() {
        controller.navigate("profile")
        controller.navigate("connection")
    }

    fun closeConnectionFlow(openProfile: Boolean = false) =
        controller.popBackStack("profile", inclusive = !openProfile)

    NavHost(controller, startDestination = "home") {
        noTransitionRoute("home") {
            Home(
                openProfile = { controller.navigate("profile") },
                openConnectionFlow = ::openConnectionFlow
            )
        }

        slideVerticallyRoute("profile") {
            Profile(
                goBack = { controller.popBackStack() },
                openConnectionFlow = ::openConnectionFlow
            )
        }

        slideVerticallyRoute("connection") {
            ConnectionRoutes(
                closeConnectionFlow = ::closeConnectionFlow,
                closeConnectionFlowAndOpenProfile = { closeConnectionFlow(openProfile = true) }
            )
        }
    }
}