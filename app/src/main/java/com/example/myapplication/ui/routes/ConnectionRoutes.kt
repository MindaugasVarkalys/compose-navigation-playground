package com.example.myapplication.ui.routes

import ConnectionSuccessful
import Login
import Mfa
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun ConnectionRoutes(
    closeConnectionFlow: () -> Unit,
    closeConnectionFlowAndOpenProfile: () -> Unit,
) {
    val connectionController = rememberNavController()
    NavHost(
        navController = connectionController,
        startDestination = "connection/login",
    ) {
        slideHorizontallyRoute("connection/login") {
            Login(
                closeConnectionFlow = closeConnectionFlow,
                openMfa = {
                    connectionController.navigate("connection/mfa")
                }
            )
        }

        slideHorizontallyRoute("connection/mfa") {
            Mfa(
                closeConnectionFlow = closeConnectionFlow,
                goBack = { connectionController.popBackStack() },
                openConnectionSuccessful = {
                    connectionController.navigate("connection/successful")
                }
            )
        }

        slideHorizontallyRoute("connection/successful") {
            ConnectionSuccessful(
                closeConnectionFlowAndOpenProfile = closeConnectionFlowAndOpenProfile,
                goBack = { connectionController.popBackStack() }
            )
        }
    }
}