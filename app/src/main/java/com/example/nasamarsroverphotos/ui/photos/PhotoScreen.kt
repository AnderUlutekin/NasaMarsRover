package com.example.nasamarsroverphotos.ui.photos

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.nasamarsroverphotos.ui.theme.NasaMarsRoverPhotosTheme
import com.example.nasamarsroverphotos.viewmodel.MainViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PhotoScreen(mainViewModel: MainViewModel) {
    val listState = mainViewModel.photosListState
    val page = mainViewModel.page

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Nasa's Mars Rover Photos") },
                backgroundColor = Color(0xFFA5A2A2),
                contentColor = Color(0xFF000000)
            )
        },
        content = {
            HorizontalPager(count = 5) { page ->
                mainViewModel.horizontalPageChange(page)
                Column {
                    Text(text = mainViewModel.errorMessage ?: "")
                    Text(text = "Camera: ${mainViewModel.cameraName.value}")
                    PhotoList(
                        photosList = listState,
                        mainViewModel = mainViewModel
                    )
                }
            }

        },
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NasaMarsRoverPhotosTheme {
        val viewModel = MainViewModel()
        PhotoList(
            photosList = viewModel.photosListState,
            mainViewModel = viewModel
        )
    }
}