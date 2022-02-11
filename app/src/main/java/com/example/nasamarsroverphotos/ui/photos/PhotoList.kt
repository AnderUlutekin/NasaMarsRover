package com.example.nasamarsroverphotos.ui.photos

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.nasamarsroverphotos.model.Photo

@Composable
fun PhotoList(photosList: List<Photo>?) {
    if (photosList != null) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
            //contentPadding = PaddingValues(16.dp)
        ) {
            items(photosList.size) { index ->
                PhotoCard(photo = photosList[index])
            }
        }
    } else {
        Text("Character List is null")
    }
}