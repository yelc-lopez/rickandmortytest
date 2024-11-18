package com.example.rickandmortytesthomeland.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.example.rickandmortytesthomeland.models.Character


@Composable
fun CharacterItem(character: Character) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = character.name,
            color = Color(0xFF211E1E),
            fontWeight = FontWeight.Bold,
            fontSize = 26.sp,
            lineHeight = 26.sp,
            modifier = Modifier.padding(vertical = 6.dp)
        )
        CharacterImage(
            imageUrl = character.image,
            modifier = Modifier
                .aspectRatio(1f)
                .clip(RoundedCornerShape(10.dp))
                .padding(end = 1.dp)
        )
    }
}

@Composable
fun CharacterImage(imageUrl: String, modifier: Modifier = defaultModifier) {
    SubcomposeAsyncImage(
        model = imageUrl,
        contentDescription = "imagen",
        modifier = modifier,
        loading = { LoadingState() }
    )
}

private val defaultModifier = Modifier
    .fillMaxSize()
    .padding(all = 64.dp)

@Composable
fun LoadingState(modifier: Modifier = defaultModifier) {
    // Loading para carga de imagenes
    CircularProgressIndicator(
        modifier = modifier,
        color = Color(0xffb5eefd)
    )
}
