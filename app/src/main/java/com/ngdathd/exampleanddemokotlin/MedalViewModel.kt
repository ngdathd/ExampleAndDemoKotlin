package com.ngdathd.exampleanddemokotlin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MedalViewModel : ViewModel() {

    val numberOfGoldMedal: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>(0)
    }
    val numberOfSilverMedal: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>(0)
    }
    val numberOfBronzeMedal: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>(0)
    }
}