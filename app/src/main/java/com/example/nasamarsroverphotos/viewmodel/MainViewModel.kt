package com.example.nasamarsroverphotos.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nasamarsroverphotos.model.Photo
import com.example.nasamarsroverphotos.services.ApiService
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel : ViewModel() {
    //var photosListResponse: List<Photos> by mutableStateOf(listOf())
//    var photosList: MutableState<List<Photo>> = mutableListOf<List<Photo>>()

    var photosListState by mutableStateOf<List<Photo>>(emptyList())

    var errorMessage by mutableStateOf<String>("")

    private fun getPhotosList() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val nasaResponse = apiService.getPhotos()
                photosListState = nasaResponse.photos
            }
            catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

    init {
        getPhotosList()
    }
}