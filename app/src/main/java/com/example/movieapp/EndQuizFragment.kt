package com.example.movieapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.movieapp.databinding.FragmentEndQuizBinding

class EndQuizFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val score = EndQuizFragmentArgs.fromBundle(requireArguments()).quizScore
        val count = EndQuizFragmentArgs.fromBundle(requireArguments()).quizCount
        val binding:FragmentEndQuizBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_end_quiz, container, false)
        binding.score = score
        binding.count = count
        return binding.root
    }

}