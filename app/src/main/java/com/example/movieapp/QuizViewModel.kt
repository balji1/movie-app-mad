package com.example.movieapp

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapp.model.Question
import com.example.movieapp.model.QuestionCatalogue

class QuizViewModel : ViewModel() {
    private val _questions = MutableLiveData<MutableList<Question>>()
    val questions: LiveData<MutableList<Question>>
        get() = _questions

    private val _currentQuestion = MutableLiveData<Question>()
    val currentQuestion: LiveData<Question>
        get() = _currentQuestion

    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    private val _index = MutableLiveData<Int>()
    val index: LiveData<Int>
        get() = _index

    private val _gameEnd = MutableLiveData<Boolean>()
    val gameEnd: LiveData<Boolean>
        get() = _gameEnd

    private val _wrongInput = MutableLiveData<Boolean>()
    val wrongInput: LiveData<Boolean>
        get() = _wrongInput

    private val _time = MutableLiveData<Long>()
    val time: LiveData<Long>
        get() = _time

    lateinit var timer: CountDownTimer

    init {
        _score.value = 0;
        _index.value = 0;
        _questions.value = QuestionCatalogue().defaultQuestions
        _currentQuestion.value = _questions.value!!.get(_index.value!!);
    }
}