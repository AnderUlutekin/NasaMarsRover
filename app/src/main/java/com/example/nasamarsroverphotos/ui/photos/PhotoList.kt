package com.example.nasamarsroverphotos.ui.photos

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.nasamarsroverphotos.Constants.PAGE_SIZE
import com.example.nasamarsroverphotos.model.Photo
import com.example.nasamarsroverphotos.viewmodel.MainViewModel

@Composable
fun PhotoList(photosList: List<Photo>?, mainViewModel: MainViewModel) {
    if (photosList != null) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
            //contentPadding = PaddingValues(16.dp)
        ) {
            items(photosList.size) { index ->
                mainViewModel.onChangePhotoScrollPosition(index)
                if ((index + 1) >= (mainViewModel.page.value * PAGE_SIZE)) {
                    mainViewModel.nextPage()
                }
                PhotoCard(photo = photosList[index])
            }
        }
    } else {
        Text("Character List is null")
    }
}