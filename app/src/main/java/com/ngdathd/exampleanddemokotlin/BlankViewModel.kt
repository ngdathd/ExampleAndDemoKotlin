package com.ngdathd.exampleanddemokotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BlankViewModel : ViewModel() {
    private val _number = MutableLiveData<Int>()
    val number: LiveData<Int>
        get() = _number

    init {
        _number.value = 0
    }

    fun setNumber(num: Int) {
        _number.value = num
    }
}