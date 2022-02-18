package com.example.nasamarsroverphotos.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nasamarsroverphotos.Constants.PAGE_SIZE
import com.example.nasamarsroverphotos.model.Photo
import com.example.nasamarsroverphotos.services.ApiService
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel() : ViewModel() {

    var photosListState by mutableStateOf<List<Photo>>(emptyList())
    var errorMessage by mutableStateOf<String>("")

    val page = mutableStateOf(1)
    val cameraName = mutableStateOf("fhaz")

    private var photosListScrollPosition = 0

    fun getPhotosList() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val nasaResponse = apiService.getPhotos(page = 1, camera = "fhaz")
                photosListState = nasaResponse.photos
            }
            catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

    fun nextPage() {
        viewModelScope.launch {

            if ((photosListScrollPosition + 1) >= (page.value * PAGE_SIZE)) {
                incrementPage()
                delay(1000)

                val apiService = ApiService.getInstance()
                if (page.value > 1) {
                    val result = apiService.getPhotos(page = page.value, camera = cameraName.value)
                    appendPhotos(result.photos)
                }
            }
        }
    }

    private fun appendPhotos(photos: List<Photo>) {
        val current = ArrayList(this.photosListState)
        current.addAll(photos)
        this.photosListState = current
    }

    private fun incrementPage() {
        page.value = page.value + 1
    }

    fun onChangePhotoScrollPosition(position: Int) {
        photosListScrollPosition = position
    }

    fun resetPage() {
        page.value = 1
    }

    fun horizontalPageChange(index: Int) {
        viewModelScope.launch {

            changeCameraName(index = index)

            val apiService = ApiService.getInstance()
            val nasaResponse = apiService.getPhotos(page = 1, camera = cameraName.value)
            changeList(nasaResponse.photos)
        }
    }

    fun changeList(photos: List<Photo>) {
        this.photosListState = photos
    }

    fun changeCameraName(index: Int) {
        cameraName.value = getCameraName(index = index)
    }

    fun getCameraName(index: Int): String {
        if (index == 0) {
            return "fhaz"
        }
        if (index == 1) {
            return "rhaz"
        }
        if (index == 2) {
            return "mast"
        }
        if (index == 3) {
            return "chemcam"
        }
        else {
            return "navcam"
        }
    }

    init {
        getPhotosList()
    }
}
