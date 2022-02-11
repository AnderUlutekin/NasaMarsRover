package com.example.nasamarsroverphotos.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nasamarsroverphotos.model.Photos
import com.example.nasamarsroverphotos.services.ApiService
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel : ViewModel() {
    var photosListResponse: List<Photos> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")
    fun getPhotosList() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val photosList = apiService.getPhotos()
                photosListResponse = photosList
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