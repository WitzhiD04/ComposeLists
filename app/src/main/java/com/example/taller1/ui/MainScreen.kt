package com.example.taller1.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.remember
import com.example.taller1.utils.PerfilImage
import com.example.taller1.utils.imagenes
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp


@Composable
fun UserItem(user: User, onUserClick: (User, Int) -> Unit, modifier: Modifier = Modifier) {
    val imagenAleatoria = remember { imagenes.random() }
    Card(
        modifier = modifier.clickable { onUserClick(user, imagenAleatoria)},
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            PerfilImage(
                idImage = imagenAleatoria,
                description = stringResource(R.string.imagen_de, user.nombre),
                modifier = Modifier.size(50.dp)
            )
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(text = stringResource(R.string.nombre, user.nombre))
                Text(
                    text = stringResource(R.string.empresa, user.company.name),
                    fontSize = 8.sp
                )
            }
            IconButton(onClick = { onUserClick(user, imagenAleatoria) }) {
                Icon(
                    painter = painterResource(R.drawable.next),
                    contentDescription = "Icono siguiente",
                    modifier = modifier.size(24.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(users: List<User>, onUserClick: (User, Int) -> Unit, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {Text(text = stringResource(R.string.total_de_usuarios, users.size)) },
                colors = androidx.compose.material3.TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        modifier = modifier
    ) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            items(users) { user ->
                UserItem(user = user, onUserClick = onUserClick, modifier = Modifier.fillMaxWidth())
            }
        }
    }
}
