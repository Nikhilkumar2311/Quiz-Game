package com.example.quizgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizgame.databinding.ActivityMathsBinding
import com.example.quizgame.databinding.ActivityScienceBinding

class MathsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMathsBinding
    private lateinit var list: ArrayList<QuestionModel>
    private var count: Int = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMathsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize the list
        list = ArrayList<QuestionModel>()

        list.add(QuestionModel("What is the result of 8 multiplied by 7?", "15","56", "64", "42","56"))
        list.add(QuestionModel(" If a rectangle has a length of 10 units and a width of 5 units, what is its area?", "25 square units","50 square units", "15 square units", "30 square units","50 square units"))
        list.add(QuestionModel("What is the square root of 144?", "12","14", "10", "16","12"))
        list.add(QuestionModel("If 3x + 5 = 20, what is the value of x?", "7","5", "3", "15","7"))
        list.add(QuestionModel("What is the result of 35 divided by 5?", "7","6", "8", "10","7"))

        binding.question.setText(list.get(0).question)
        binding.Option1.setText(list.get(0).Option1)
        binding.Option2.setText(list.get(0).Option2)
        binding.Option3.setText(list.get(0).Option3)
        binding.Option4.setText(list.get(0).Option4)

        binding.Option1.setOnClickListener {
            nextData(binding.Option1.text.toString())
        }
        binding.Option2.setOnClickListener {
            nextData(binding.Option2.text.toString())
        }
        binding.Option3.setOnClickListener {
            nextData(binding.Option3.text.toString())
        }
        binding.Option4.setOnClickListener {
            nextData(binding.Option4.text.toString())
        }
    }

    private fun nextData(i: String){

        if (count<list.size){
            if (list.get(count).ans.equals(i)){
                score++
            }
        }

        count++
        if (count>=list.size){
            val intent = Intent(this, ScoreActivity::class.java)
            intent.putExtra("SCORE4", score)
            startActivity(intent)
            finish()
        }
        else{
            binding.question.setText(list.get(count).question)
            binding.Option1.setText(list.get(count).Option1)
            binding.Option2.setText(list.get(count).Option2)
            binding.Option3.setText(list.get(count).Option3)
            binding.Option4.setText(list.get(count).Option4)
        }

    }
}