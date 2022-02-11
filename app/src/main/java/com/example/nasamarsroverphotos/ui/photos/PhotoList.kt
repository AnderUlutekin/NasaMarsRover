package com.example.nasamarsroverphotos.ui.photos

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.nasamarsroverphotos.model.Photos

@Composable
fun PhotoList(photosList: List<Photos>?) {
    if (photosList != null) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
            //contentPadding = PaddingValues(16.dp)
        ) {
            items(photosList.size) { index ->
                PhotoCard(myPhoto = photosList[index])
            }
        }
    } else {
        Text("Character List is null")
    }
}