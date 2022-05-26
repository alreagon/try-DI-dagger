package com.example.c7_dagger.data.service

class ApiHelper(private val apiService: ApiService) {
    suspend fun getAllCars() = apiService.getAllCars()
}