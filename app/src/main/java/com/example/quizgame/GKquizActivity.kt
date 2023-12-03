package com.example.quizgame

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GKquizActivity : AppCompatActivity() {

    private lateinit var questionTextView: TextView
    private lateinit var option1Button: Button
    private lateinit var option2Button: Button
    private lateinit var option3Button: Button
    private lateinit var option4Button: Button

    private lateinit var list: ArrayList<QuestionModel>
    private var count: Int = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gkquiz)

        // Initialize the list
        list = ArrayList<QuestionModel>()

        list.add(QuestionModel("Which planet is known as the Red Planet?", "Venus", "Mars", "Jupiter", "Saturn", "Mars"))
        list.add(QuestionModel("Who wrote the famous play Romeo and Juliet?", "Charles Dickens","William Shakespeare", "Jane Austen", "Mark Twain","William Shakespeare"))
        list.add(QuestionModel("What is the largest mammal in the world?", "African Elephant","Blue Whale", "Giraffe", "Polar Bear","Blue Whale"))
        list.add(QuestionModel("Which famous ancient wonder was located in the city of Alexandria in Egypt?", "The Hanging Gardens of Babylon","The Statue of Zeus at Olympia", "The Lighthouse of Alexandria", "The Temple of Artemis at Ephesus","The Lighthouse of Alexandria"))
        list.add(QuestionModel("What is the chemical symbol for gold?", "Gd","Au", "Ag", "Go","Au"))

        questionTextView = findViewById(R.id.question)
        option1Button = findViewById(R.id.Option1)
        option2Button = findViewById(R.id.Option2)
        option3Button = findViewById(R.id.Option3)
        option4Button = findViewById(R.id.Option4)

        questionTextView.text = list[0].question
        option1Button.text = list[0].Option1
        option2Button.text = list[0].Option2
        option3Button.text = list[0].Option3
        option4Button.text = list[0].Option4

        option1Button.setOnClickListener {
            nextData(option1Button.text.toString())
        }
        option2Button.setOnClickListener {
            nextData(option2Button.text.toString())
        }
        option3Button.setOnClickListener {
            nextData(option3Button.text.toString())
        }
        option4Button.setOnClickListener {
            nextData(option4Button.text.toString())
        }
    }

    private fun nextData(selectedOption: String) {
        if (count < list.size) {
            if (list[count].ans == selectedOption) {
                score++
            }
        }

        count++
        if (count >= list.size) {
            val intent = Intent(this, ScoreActivity::class.java)
            intent.putExtra("SCORE1", score)
            startActivity(intent)
            finish()
        } else {
            questionTextView.text = list[count].question
            option1Button.text = list[count].Option1
            option2Button.text = list[count].Option2
            option3Button.text = list[count].Option3
            option4Button.text = list[count].Option4
        }
    }
}
