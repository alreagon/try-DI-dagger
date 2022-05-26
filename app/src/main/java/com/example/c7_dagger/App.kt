package com.example.c7_dagger

import android.app.Application
import com.example.c7_dagger.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App : Application() ,HasAndroidInjector {


//
//    @Inject
//    lateinit var mInjector:DispatchingAndroidInjector<Any>

//
//    override fun onCreate() {
//        super.onCreate()
//        DaggerAppComponent.bulder()
//            .appModule(AppModule(this))
//            .build()
//            .inject(this)
//    }
//
//    override fun androidInjector(): AndroidInjector<Any> {
//        return mInjector
//    }


    private val injector = DaggerAppComponent //DaggerAppComponent ini harus di rebuld dulu biar gk merah
        .builder()
        .application(this)
        .build()

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }
}