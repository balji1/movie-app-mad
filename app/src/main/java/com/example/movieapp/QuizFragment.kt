package com.example.movieapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.movieapp.databinding.FragmentQuizBinding


class QuizFragment : Fragment() {

    private lateinit var binding: FragmentQuizBinding
    private lateinit var quizViewModel: QuizViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_quiz, container, false);
        binding.btnNext.setOnClickListener{nextQuestion()}

        quizViewModel = ViewModelProvider(this).get(QuizViewModel::class.java) //Get current state of view model
        binding.quizViewModel = quizViewModel


        return binding.root;
    }

    private fun nextQuestion() {

    }

}