package com.example.quizgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quizgame.databinding.ActivityGkquizBinding

class GKquizActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGkquizBinding
    private lateinit var list: ArrayList<QuestionModel>
    private var count: Int = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGkquizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize the list
        list = ArrayList<QuestionModel>()

        list.add(QuestionModel("Which planet is known as the Red Planet?", "Venus","Mars", "Jupiter", "Saturn","Mars"))
        list.add(QuestionModel("Who wrote the famous play Romeo and Juliet?", "Charles Dickens","William Shakespeare", "Jane Austen", "Mark Twain","William Shakespeare"))
        list.add(QuestionModel("What is the largest mammal in the world?", "African Elephant","Blue Whale", "Giraffe", "Polar Bear","Blue Whale"))
        list.add(QuestionModel("Which famous ancient wonder was located in the city of Alexandria in Egypt?", "The Hanging Gardens of Babylon","The Statue of Zeus at Olympia", "The Lighthouse of Alexandria", "The Temple of Artemis at Ephesus","The Lighthouse of Alexandria"))
        list.add(QuestionModel("What is the chemical symbol for gold?", "Gd","Au", "Ag", "Go","Au"))

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
            intent.putExtra("SCORE1", score)
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
