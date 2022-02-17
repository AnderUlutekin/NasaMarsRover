package com.example.nasamarsroverphotos.services

import com.example.nasamarsroverphotos.Constants.API_KEY
import com.example.nasamarsroverphotos.Constants.BASE_URL
import com.example.nasamarsroverphotos.model.NasaResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=$API_KEY")
    suspend fun getPhotos(@Query("page") page: Int): NasaResponse

    companion object {
        var apiService: ApiService? = null

        fun getInstance(): ApiService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}