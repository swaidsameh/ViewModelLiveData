package com.example.viewmodellivedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
    private val counterLiveData = MutableLiveData<Int>()
    private var counter = 0
    fun getInitialCounter():MutableLiveData<Int> {
        counterLiveData.value = counter
        return counterLiveData
    }
    fun getCounter() {
        counter++
        counterLiveData.value = counter
    }

}