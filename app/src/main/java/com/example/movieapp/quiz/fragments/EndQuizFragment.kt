package com.example.movieapp.quiz.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentEndQuizBinding
import com.example.movieapp.quiz.viewModels.EndQuizViewModel

class EndQuizFragment : Fragment() {

    private lateinit var quizEndViewModel: EndQuizViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentEndQuizBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_end_quiz, container, false)

        //Init view model with the current state
        quizEndViewModel = ViewModelProvider(this).get(EndQuizViewModel::class.java)

        binding.quizEndViewModel = quizEndViewModel
        quizEndViewModel.score.value = EndQuizFragmentArgs.fromBundle(requireArguments()).quizScore
        quizEndViewModel.count.value = EndQuizFragmentArgs.fromBundle(requireArguments()).quizCount

        //Binding btn listener and navigating to QuizFragment
        binding.btnQuizRestart.setOnClickListener { view?.findNavController()?.navigate(EndQuizFragmentDirections.actionEndQuizFragmentToQuizFragment()) }

        return binding.root
    }

}