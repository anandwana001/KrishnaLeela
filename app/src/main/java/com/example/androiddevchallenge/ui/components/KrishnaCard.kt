package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bumptech.glide.request.RequestOptions
import com.example.androiddevchallenge.model.KrishnaLifeEvent
import dev.chrisbanes.accompanist.glide.GlideImage

@Composable
fun KrishnaCard(event: KrishnaLifeEvent, onClick: () -> Unit) {
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 8.dp,
                bottom = 8.dp
            )
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = 8.dp
    ) {
        Column {
            Image(imageUrl = event.image)
            Title(event = event.title)
        }
    }
}

@Composable
fun Title(event: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp, 12.dp, 8.dp, 12.dp)
    ) {
        Text(
            text = event,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.Start),
            style = MaterialTheme.typography.h6
        )
    }
}

@Composable
fun Image(imageUrl: String) {
    GlideImage(
        data = imageUrl,
        contentDescription = "krishna image",
        modifier = Modifier
            .height(180.dp)
            .fillMaxWidth(),
        requestBuilder = {
            val options = RequestOptions()
            options.centerCrop()
            apply(options)
        }
    )
}
