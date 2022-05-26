package com.example.c7_dagger.data.service

import com.example.c7_dagger.data.model.GetAllCarsResponseItem
import retrofit2.http.GET

interface ApiService {
    @GET("admin/car")
    suspend fun getAllCars(): List<GetAllCarsResponseItem>
}