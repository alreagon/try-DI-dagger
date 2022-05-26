package com.example.c7_dagger.di

import com.example.c7_dagger.ui.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract  class ActivityModule {
    @ContributesAndroidInjector
    abstract fun mvvmMainActivity() : MainActivity
}
//Activity yg menggunakan depedency dari module yg disediakan, activitynya WAJIB dibuat module jg
//misal ada registerActivity menggunakan depedency yg di inject, registerActivity itu harus di tambahkan disini