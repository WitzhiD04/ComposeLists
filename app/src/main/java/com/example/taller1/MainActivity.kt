package com.example.taller1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.Surface
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.taller1.navigation.NavigationStack
import com.example.taller1.ui.theme.Taller1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var darkTheme by remember { mutableStateOf(false) }
            Taller1Theme(
                darkTheme = darkTheme
            ) {
                Surface {
                    NavigationStack(
                        onToggleTheme = {darkTheme = !darkTheme},
                        isDarkTheme = darkTheme
                    )
                }
            }
        }
    }
}
