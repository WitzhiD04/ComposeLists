package com.example.taller1.navigation

sealed class Screen(val route: String) {
    object Main : Screen("main")
    object Detail : Screen("detail")
}
