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
fun NavigationStack(onToggleTheme: ()->Unit, isDarkTheme: Boolean) {

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
            MainScreen(
                users = users.value,
                onUserClick = { user ->
                navController.navigate(Screen.Detail.route + "?userId=${user.id}")},
                onToggleTheme = onToggleTheme,
                isDarkTheme = isDarkTheme
                )
            }

        // Destino de navegación UserDetailScreen
        composable(
            route = Screen.Detail.route + "?userId={userId}",
            arguments = listOf(
                navArgument(name = "userId") {
                    type = NavType.StringType
                    nullable = true
                }
            )
        ) {
            val userId = it.arguments?.getString("userId")?.toIntOrNull()
            val user = users.value.find { it.id == userId }

            if (user != null) {
                UserDetailScreen(user = user, image = user.image, modifier = Modifier.fillMaxSize())
            }
        }
    }
}