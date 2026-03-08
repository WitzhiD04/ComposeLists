package com.example.taller1.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.taller1.model.User
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.size
import androidx.compose.ui.res.stringResource
import com.example.taller1.R
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import com.example.taller1.utils.PerfilImage
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.IconButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@Composable
fun UserItem(user: User, onUserClick: (User) -> Unit, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.clickable { onUserClick(user)},
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        ListItem(
            headlineContent = { Text(stringResource(R.string.fullnam, user.nombre, user.apellido)) },
            supportingContent = { Text(user.company.name, fontSize = 16.sp) },
            leadingContent = {
                PerfilImage(
                    url = user.image,
                    description = "",
                    modifier = Modifier.size(50.dp)
                )
            },
            trailingContent = {
                Icon(
                    painter = painterResource(R.drawable.next),
                    contentDescription = "Icono siguiente",
                    modifier = Modifier.size(24.dp)
                )
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    users: List<User>,
    onUserClick: (User) -> Unit,
    onToggleTheme: () -> Unit,
    isDarkTheme: Boolean,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        stickyHeader {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary)
                    .statusBarsPadding()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(R.string.total_de_usuarios, users.size),
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                IconButton(onClick = onToggleTheme) {
                    Icon(
                        imageVector = if (isDarkTheme) Icons.Default.LightMode else Icons.Default.DarkMode,
                        contentDescription = "Toggle theme",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }
        items(users) { user ->
            UserItem(user = user, onUserClick = onUserClick, modifier = Modifier.fillMaxWidth())
        }
    }
}