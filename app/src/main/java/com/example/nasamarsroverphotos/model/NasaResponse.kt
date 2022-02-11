package com.example.nasamarsroverphotos.model


import com.google.gson.annotations.SerializedName

data class NasaResponse(
    @SerializedName("photos")
    val photos: List<Photo>
)