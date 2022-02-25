package com.example.nasamarsroverphotos.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nasamarsroverphotos.Constants
import com.example.nasamarsroverphotos.model.Photo
import com.example.nasamarsroverphotos.services.ApiService
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception

class HorizontalViewModel() : ViewModel() {
    var photosListState by mutableStateOf<List<Photo>>(emptyList())

    val cameraName = mutableStateOf("fhaz")

    fun changePage(index: Int, mainViewModel: MainViewModel) {
        viewModelScope.launch {
            changeCameraName(index = index, mainViewModel = mainViewModel)
            val apiService = ApiService.getInstance()
            val result = apiService.getPhotos(1, camera = cameraName.value)
            changePhotos(photos = result.photos, mainViewModel = mainViewModel)
        }
    }

    fun changePhotos(photos: List<Photo>, mainViewModel: MainViewModel) {
        this.photosListState = photos
        mainViewModel.photosListState = this.photosListState
    }

    fun changeCameraName(index: Int, mainViewModel: MainViewModel) {
        cameraName.value = getCameraName(index = index)
        mainViewModel.cameraName.value = cameraName.value
    }

    fun getCameraName(index: Int) : String {
        if (index == 0) {
            return "fhaz"
        } else if (index == 1) {
            return "rhaz"
        } else if (index == 2) {
            return "mast"
        } else if (index == 3) {
            return "chemcam"
        } else {
            return "navcam"
        }
    }
}