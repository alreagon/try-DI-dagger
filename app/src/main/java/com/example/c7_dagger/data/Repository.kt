package com.example.c7_dagger.data

import com.example.c7_daggerhilt.data.service.ApiHelper

class Repository(private val apiHelper: ApiHelper) {
    suspend fun getPosts() = apiHelper.getAllCars()
}