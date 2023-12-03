package com.example.quizgame

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MathsActivity : AppCompatActivity() {

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
        setContentView(R.layout.activity_maths)

        // Initialize the list
        list = ArrayList<QuestionModel>()

        list.add(QuestionModel("What is the result of 8 multiplied by 7?", "15", "56", "64", "42", "56"))
        list.add(QuestionModel(" If a rectangle has a length of 10 units and a width of 5 units, what is its area?", "25 square units","50 square units", "15 square units", "30 square units","50 square units"))
        list.add(QuestionModel("What is the square root of 144?", "12","14", "10", "16","12"))
        list.add(QuestionModel("If 3x + 5 = 20, what is the value of x?", "7","5", "3", "15","7"))
        list.add(QuestionModel("What is the result of 35 divided by 5?", "7","6", "8", "10","7"))

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
            intent.putExtra("SCORE4", score)
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
