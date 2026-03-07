package com.example.taller1.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import com.example.taller1.model.User
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.taller1.R
import com.example.taller1.utils.PerfilImage
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.taller1.ui.theme.greenColor
import androidx.compose.foundation.clickable
import android.net.Uri
import android.content.Intent
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import com.example.taller1.utils.InfoUser

@Composable
fun Llamada (user: User) {
    val ctx = LocalContext.current
    Text(
        stringResource(R.string.t_lefono, user.celular),
        color = greenColor,
        modifier = Modifier.clickable {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:${user.celular}")
            }
            ctx.startActivity(intent)

        }
    )
}

@Composable
fun UserText(user: User, modifier: Modifier) {
    val phoneNumber by remember { mutableStateOf(user.celular) }
    Column(
        modifier = modifier,
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        InfoUser(user = user)
    }
}

@Composable
fun UserData (user: User, image: Int, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        PerfilImage(image, description = stringResource(R.string.imagen_de, user.nombre), modifier = Modifier.size(200.dp))
        Text(
            stringResource(R.string.fullname, user.nombre, user.apellido),
            modifier = Modifier.fillMaxWidth(),
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center
        )
        UserText(user = user, modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
        )
    }
}

@Composable
fun UserDetailScreen (user: User, image: Int, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        PerfilImage(R.drawable.purple, "fondo pantalla", modifier = Modifier.fillMaxSize())
        UserData(user = user, image = image, modifier = Modifier.fillMaxSize())
    }
}