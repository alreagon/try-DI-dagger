package com.example.c7_dagger.di

import android.app.Application
import com.example.c7_dagger.App
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

//@Component untuk mengaktifkan module, semua module di taro di sini
@Component(
    modules = [
        AndroidInjectionModule::class, //<== Ini WAJIB ditamahin atau bisa make AndroidSupportInjectionModule::class
        RepositoryModule::class,
        ActivityModule::class,
        ViewModelModule::class,
        NetworkModule::class
    ]
)

interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    override fun inject(baseApplication: App)
}