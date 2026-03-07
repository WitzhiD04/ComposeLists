package com.example.taller1.utils

import androidx.compose.foundation.Image
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.taller1.R
import com.example.taller1.model.User
import com.example.taller1.ui.Llamada

val imagenes = listOf(
    R.drawable.p1,
    R.drawable.p2,
    R.drawable.p3,
    R.drawable.p4,
    R.drawable.p5,
    R.drawable.p6
)

@Composable
fun PerfilImage(idImage: Int, description: String, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(idImage),
        contentDescription = description,
        modifier = modifier,
        contentScale = ContentScale.Crop
    )
}

@Composable
fun InfoUser(user: User) {
    Text(stringResource(R.string.empresa2, user.company.name))
    Llamada(user = user)
    Text(stringResource(R.string.email, user.mail))
    Text(stringResource(R.string.edad, user.edad))
    Text(stringResource(R.string.altura, user.altura))
    Text(stringResource(R.string.peso, user.peso))
    Text(stringResource(R.string.universidad, user.universidad))
}