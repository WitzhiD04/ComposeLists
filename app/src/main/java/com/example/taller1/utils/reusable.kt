package com.example.taller1.utils

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.taller1.R

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