package com.example.quizgame

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ComputerActivity : AppCompatActivity() {

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
        setContentView(R.layout.activity_computer)

        // Initialize the list
        list = ArrayList<QuestionModel>()

        list.add(QuestionModel("What does CPU stand for?", "Central Processing Unit", "Computer Programming Unit", "Central Program Utility", "Computer Power Unit", "Central Processing Unit"))
        list.add(QuestionModel("Which programming language is commonly used for web development?", "Java","Python", "HTML", "C++","HTML"))
        list.add(QuestionModel("What is the purpose of an operating system?", "To play games","To manage hardware and software resources", "To create documents and spreadsheets", "To browse the internet","To manage hardware and software resources"))
        list.add(QuestionModel("Which storage device provides the fastest data access times?", "Hard Disk Drive (HDD)","Solid State Drive (SSD)", "Blu-ray Disc", "DVD-ROM","Solid State Drive (SSD)"))
        list.add(QuestionModel("Which networking protocol is commonly used to transfer files over the Internet?", "HTTP","FTP", "SMTP", "POP3","FTP"))
        list.add(QuestionModel("What is the binary equivalent of the decimal number 25?", "10010","11001", "10101", "11100","10010"))

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
            intent.putExtra("SCORE2", score)
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