package com.example.nasamarsroverphotos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.SavedStateHandle
import com.example.nasamarsroverphotos.ui.photos.PhotoScreen
import com.example.nasamarsroverphotos.ui.theme.NasaMarsRoverPhotosTheme
import com.example.nasamarsroverphotos.viewmodel.HorizontalViewModel
import com.example.nasamarsroverphotos.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NasaMarsRoverPhotosTheme {
                val horizontalViewModel = HorizontalViewModel(SavedStateHandle())
                PhotoScreen(
                    mainViewModel = MainViewModel(horizontalViewModel = horizontalViewModel),
                    horizontalViewModel = horizontalViewModel
                )
            }
        }
    }
}