package com.example.nasamarsroverphotos.ui.photos

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.nasamarsroverphotos.ui.theme.NasaMarsRoverPhotosTheme
import com.example.nasamarsroverphotos.viewmodel.HorizontalViewModel
import com.example.nasamarsroverphotos.viewmodel.MainViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PhotoScreen(mainViewModel: MainViewModel, horizontalViewModel: HorizontalViewModel) {
    val listState = mainViewModel.photosListState
    val pagerState = rememberPagerState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Nasa's Mars Rover Photos") },
                backgroundColor = Color(0xFFA5A2A2),
                contentColor = Color(0xFF000000)
            )
        },
        content = {
            HorizontalPager(
                count = 5,
                state = pagerState
            ) {
                when (pagerState.currentPage) {
                    0 -> horizontalViewModel.changePage(index = 0, mainViewModel = mainViewModel)
                    1 -> horizontalViewModel.changePage(index = 1, mainViewModel = mainViewModel)
                    2 -> horizontalViewModel.changePage(index = 2, mainViewModel = mainViewModel)
                    3 -> horizontalViewModel.changePage(index = 3, mainViewModel = mainViewModel)
                    4 -> horizontalViewModel.changePage(index = 4, mainViewModel = mainViewModel)
                }
                Column {
                    Text(text = mainViewModel.errorMessage ?: "")
                    Text(text = "Camera: ${horizontalViewModel.cameraName.value}")
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
        val viewModel = MainViewModel(horizontalViewModel = HorizontalViewModel())
        PhotoList(
            photosList = viewModel.photosListState,
            mainViewModel = viewModel
        )
    }
}