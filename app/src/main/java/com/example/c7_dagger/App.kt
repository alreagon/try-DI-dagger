package com.example.c7_dagger

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {
    private val injector = DaggerAppComponent //DaggerAppComponent ini harus di rebuld dulu biar gk merah
        .builder()
        .application(this)
        .build()

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return injector
    }
}