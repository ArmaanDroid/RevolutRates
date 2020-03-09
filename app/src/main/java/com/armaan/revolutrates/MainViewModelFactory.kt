package com.armaan.revolutrates

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException
import kotlin.concurrent.thread

// Not useful in this scenario but helps a lot when the dependencies for View model are a lot
class MainViewModelFactory : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}