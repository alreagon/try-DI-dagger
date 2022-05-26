package com.example.c7_dagger.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.c7_dagger.data.Repository
import com.example.c7_dagger.data.Resource
import com.example.c7_dagger.data.model.GetAllCarsResponseItem
import kotlinx.coroutines.launch
import javax.inject.Inject

//@inject cons WAJIB dipake kalo kita make binds di class yg manggil class tersebut,
//kasusnya kayak class ini dipanggil sama VMModule dgn menggunakan binds, jadi ini wajib make @Inject const,
//walaupun class nya gk make contructor, WAJIB dipake
class MainActivityViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel(){


    private val _posts = MutableLiveData<Resource<List<GetAllCarsResponseItem>>>()
    val posts: LiveData<Resource<List<GetAllCarsResponseItem>>>
        get() = _posts

    fun getAllPosts(){
        viewModelScope.launch {
            _posts.postValue(Resource.loading())
            try {
                _posts.postValue(Resource.success(repository.getPosts()))
            }catch (exception: Exception){
                _posts.postValue(Resource.error(exception.message ?: "Error Occurred"))
            }
        }
    }

}