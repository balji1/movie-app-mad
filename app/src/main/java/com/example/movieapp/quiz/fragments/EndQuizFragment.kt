package com.example.movieapp.quiz.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentEndQuizBinding
import com.example.movieapp.quiz.viewModels.EndQuizViewModel

class EndQuizFragment : Fragment() {

    private lateinit var quizEndViewModel: EndQuizViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding:FragmentEndQuizBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_end_quiz, container, false)

        quizEndViewModel =
            ViewModelProvider(this).get(EndQuizViewModel::class.java) //Init Viewmodel with the current state

        binding.quizEndViewModel = quizEndViewModel
        quizEndViewModel.score.value = EndQuizFragmentArgs.fromBundle(
            requireArguments()
        ).quizScore
        quizEndViewModel.count.value = EndQuizFragmentArgs.fromBundle(
            requireArguments()
        ).quizCount

        return binding.root
    }

}