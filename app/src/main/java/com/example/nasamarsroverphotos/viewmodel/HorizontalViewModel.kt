package com.example.nasamarsroverphotos.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.nasamarsroverphotos.model.Photo

class HorizontalViewModel() : ViewModel() {
    var photosListState by mutableStateOf<List<Photo>>(emptyList())

    val cameraName = mutableStateOf("fhaz")

    fun changeCameraName(index: Int) {
        cameraName.value = getCameraName(index = index)
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