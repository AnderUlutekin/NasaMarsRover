package com.example.nasamarsroverphotos.ui.photos

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.nasamarsroverphotos.model.Photo

@Composable
fun PhotoCard(photo: Photo) {
    Log.d("Debug", photo.imgSrc)
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color(0xFFA5A2A2),
        modifier = Modifier
            .height(220.dp)
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(all = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                Image(
                    painter = rememberImagePainter(photo.imgSrc),
                    contentDescription = null,
                    modifier = Modifier.size(150.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row() {
                Text(
                    text = "${photo.id}"
                )
            }
        }
    }
}