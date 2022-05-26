package com.example.c7_dagger.di

import com.example.c7_dagger.data.Repository
import com.example.c7_dagger.data.service.ApiHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object RepositoryModule {

    @Singleton // buat ngasih tau ini tuh singleton, f: untuk intansiasi satu kali dan dipake berkali" dipanggil dmn pun
    @Provides //menyediakan depedensi nya
    fun provideRepository(apiHelper: ApiHelper) = Repository(apiHelper)
}