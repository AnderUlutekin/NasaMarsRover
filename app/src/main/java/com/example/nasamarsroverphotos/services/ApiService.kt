package com.example.nasamarsroverphotos.services

import com.example.nasamarsroverphotos.model.NasaResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val API_KEY = "EVFSseDuvpLeZ06jj2EBUScq12XtUSE4rVLbxIzg"

interface ApiService {
    @GET("mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=$API_KEY&page=1")
    suspend fun getPhotos(): NasaResponse

    companion object {
        var apiService: ApiService? = null

        fun getInstance(): ApiService {
            if (apiService == null) {
//                val client = OkHttpClient.Builder()
//                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
//                    .build()

                apiService = Retrofit.Builder()
//                    .client(client)
                    .baseUrl("https://api.nasa.gov/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}