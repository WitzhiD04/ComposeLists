package com.example.taller1.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.taller1.api.KtorApiClient
import com.example.taller1.model.User
import com.example.taller1.ui.MainScreen
import com.example.taller1.ui.UserDetailScreen

@Composable
fun NavigationStack() {

    val navController = rememberNavController()
    val users = remember { mutableStateOf(listOf<User>()) }

    // Consulta al API de usuarios
    LaunchedEffect(Unit) {
        users.value = KtorApiClient.getUsers().users
    }

    // Estructura de navegación (NavGraph, conjunto de destinos navegables dentro de la app)
    NavHost(
        navController = navController,
        startDestination = Screen.Main.route
    ) {

        // Destino de navegación MainScreen
        composable(route = Screen.Main.route) {
            MainScreen(users = users.value, onUserClick = { user, imageId ->
                navController.navigate(
                    route = Screen.Detail.route + "?userId=${user.id}&imageId=$imageId"
                )
            })
        }

        // Destino de navegación UserDetailScreen
        composable(
            route = Screen.Detail.route + "?userId={userId}&imageId={imageId}",
            arguments = listOf(
                navArgument(name = "userId") {
                    type = NavType.StringType
                    nullable = true
                },
                navArgument(name = "imageId") {
                    type = NavType.IntType
                    defaultValue = 0
                }
            )
        ) {
            val userId = it.arguments?.getString("userId")?.toIntOrNull()
            val user = users.value.find { it.id == userId }
            val imageId = it.arguments?.getInt("imageId") ?: 0

            if (user != null) {
                UserDetailScreen(user = user, image = imageId, modifier = Modifier.fillMaxSize())
            }
        }
    }
}