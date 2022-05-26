package com.example.c7_dagger.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.c7_dagger.ui.viewmodel.MainActivityViewModel
import com.example.c7_dagger.ui.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass


@Module
abstract class ViewModelModule {

    @Binds //ini kek provide
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class) // MainActivityVM jadi keynya trus di provde v
    internal abstract fun bindMVVMMainViewModel(mVVMainViewModel: MainActivityViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    //yg ngebedain antara module ini dgn module" yg lainnya itu module ini ada Binds nyatu sama abstract
    //yg module lain make provide, disini make binds
    //kalo make binds, wajib make inject constructor di classnya, walaupun di class gk make const
}

// INI WAJIB!!!!
// Di dagger WAJIB menambahkan ViewModelKey dan ViewModelFactory(Meskipun kita gk make parameter/cons di VM nya)

//=== ini viewmodelkey
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)
//=== sampe sini viewmodelkey

//ViewModelKey ini bisa digabung di ViewModelModule spt saat ini,
//atau boleh jg dipisah class nya
