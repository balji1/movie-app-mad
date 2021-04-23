package com.example.movieapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EndQuizViewModel: ViewModel() {

    private val _score = MutableLiveData<Int>()
    val score: MutableLiveData<Int>
        get() = _score

    private val _count = MutableLiveData<Int>()
    val count: MutableLiveData<Int>
        get() = _count
}