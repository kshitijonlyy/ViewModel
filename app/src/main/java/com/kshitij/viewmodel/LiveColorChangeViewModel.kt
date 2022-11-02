package com.kshitij.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveColorChangeViewModel : ViewModel() {
    var color: MutableLiveData<Int> = MutableLiveData(0)
}