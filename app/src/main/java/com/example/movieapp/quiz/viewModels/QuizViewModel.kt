package com.example.movieapp.quiz.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapp.quiz.model.Question
import com.example.movieapp.quiz.model.QuestionCatalogue

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


    init {
        _score.value = 0;
        _index.value = 0;
        _questions.value = QuestionCatalogue().defaultQuestions
        _currentQuestion.value = _questions.value!!.get(_index.value!!);
    }

    fun incrementScore(){
        _score.value = _score.value?.plus(1)
    }

    fun incrementIndex(){
        _index.value = _index.value?.plus(1)
    }

    fun setNextQuestion(){
        _currentQuestion.value = _questions.value!![_index.value!!]
    }

    fun setEndGame(value: Boolean){
        _gameEnd.value = value
    }
}