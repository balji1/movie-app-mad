package com.example.movieapp.quiz.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentQuizBinding
import com.example.movieapp.quiz.viewModels.QuizViewModel


class QuizFragment : Fragment() {

    private lateinit var binding: FragmentQuizBinding
    private lateinit var quizViewModel: QuizViewModel
    private val idIfNothingSelected = -1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_quiz, container, false)

        //Get current state of view model
        quizViewModel = ViewModelProvider(this).get(QuizViewModel::class.java)

        binding.quizViewModel = quizViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        quizViewModel.gameEnd.observe(viewLifecycleOwner, Observer { newEndGame ->
            if (newEndGame) {
                view?.findNavController()?.navigate(
                    QuizFragmentDirections.actionQuizFragmentToEndQuizFragment(
                        quizViewModel.score.value!!,
                        quizViewModel.questions.value!!.size
                    )
                )
            }
        })

        binding.btnNext.setOnClickListener { nextQuestion() }


        return binding.root;
    }

    private fun nextQuestion() {

        //View ID from selected Radio button
        val answerId = binding.answerBox.checkedRadioButtonId
        if (answerId == idIfNothingSelected) {
            Toast.makeText(activity, "Please select an answer", Toast.LENGTH_LONG).show()
            return
        }
        //get the selected radio button
        val radioButton: View = binding.answerBox.findViewById(answerId);
        //Pos of selected radio button
        val index = binding.answerBox.indexOfChild(radioButton)

        if (quizViewModel.currentQuestion.value!!.answers[index].isCorrectAnswer) {
            quizViewModel.incrementScore()
        }

        binding.answerBox.clearCheck()
        quizViewModel.incrementIndex()

        if (quizViewModel.index.value!! > quizViewModel.questions.value!!.size - 1) {
            quizViewModel.setEndGame(true)
            return
        }

        quizViewModel.setNextQuestion()
    }

}