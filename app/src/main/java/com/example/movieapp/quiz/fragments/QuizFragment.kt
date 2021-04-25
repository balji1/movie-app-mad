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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_quiz, container, false)


        quizViewModel =
            ViewModelProvider(this).get(QuizViewModel::class.java) //Get current state of view model
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
        //Check if question selected
        //--> if not Toast
        //Move to next Question
        var answerId = binding.answerBox.checkedRadioButtonId //View ID from selected Radio button
        if (answerId == -1) {
            Toast.makeText(activity, "Please select an answer", Toast.LENGTH_LONG).show()
            return
        }
        val radioButton: View = binding.answerBox.findViewById(answerId); //get the selected radio button
        val index = binding.answerBox.indexOfChild(radioButton) //Pos of selected radio button

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