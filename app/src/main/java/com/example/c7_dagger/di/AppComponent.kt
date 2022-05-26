package com.example.c7_dagger.di

import android.app.Application
import com.example.c7_dagger.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import javax.inject.Singleton

//@Component untuk mengaktifkan module, semua module di taro di sini
@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class, //<== Ini WAJIB ditamahin atau bisa make AndroidSupportInjectionModule::class
        RepositoryModule::class,
        ActivityModule::class,
        ViewModelModule::class,
        NetworkModule::class
    ]
)

interface AppComponent  {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(baseApplication: Application)
}