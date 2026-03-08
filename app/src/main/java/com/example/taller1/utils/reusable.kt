package com.example.taller1.utils

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.taller1.R
import com.example.taller1.model.User
import com.example.taller1.ui.Llamada
import com.example.taller1.ui.Mail

@Composable
fun PerfilImage(url: String, description: String, modifier: Modifier = Modifier) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .crossfade(true)
            .build(),
        placeholder = painterResource(R.drawable.p1),
        contentDescription = description,
        contentScale = ContentScale.Crop,
        modifier = modifier.clip(CircleShape),
    )
}

@Composable
fun InfoUser(user: User) {
    Text(stringResource(R.string.empresa2, user.company.name))
    Llamada(user = user)
    Mail(user = user)
    Text(stringResource(R.string.edad, user.edad))
    Text(stringResource(R.string.altura, user.altura))
    Text(stringResource(R.string.peso, user.peso))
    Text(stringResource(R.string.universidad, user.universidad))
}