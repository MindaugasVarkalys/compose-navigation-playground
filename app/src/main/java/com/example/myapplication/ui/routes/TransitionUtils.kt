package com.example.myapplication.ui.routes

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.noTransitionRoute(
    route: String,
    content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) = composable(
    route = route,
    content = content,
    enterTransition = { EnterTransition.None },
    // Hacky way to make it stay.
    // Somehow it shows white screen during transition if ExitTransition.None is used
    exitTransition = { fadeOut(animationSpec = tween(delayMillis = 2000)) },
    popEnterTransition = { EnterTransition.None },
    popExitTransition = { ExitTransition.None },
)

fun NavGraphBuilder.slideHorizontallyRoute(
    route: String,
    content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) = composable(
    route = route,
    content = content,
    enterTransition = { slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Start) },
    exitTransition = { slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Start) },
    popEnterTransition = { slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.End) },
    popExitTransition = { slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.End) },
)

fun NavGraphBuilder.slideVerticallyRoute(
    route: String,
    content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) = composable(
    route = route,
    content = content,
    enterTransition = { slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Up) },
    exitTransition = { ExitTransition.None },
    popEnterTransition = { EnterTransition.None },
    popExitTransition = { slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Down) },
)