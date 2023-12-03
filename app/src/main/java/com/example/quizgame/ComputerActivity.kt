package com.example.quizgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizgame.databinding.ActivityComputerBinding
import com.example.quizgame.databinding.ActivityGkquizBinding

class ComputerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityComputerBinding
    private lateinit var list: ArrayList<QuestionModel>
    private var count: Int = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComputerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize the list
        list = ArrayList<QuestionModel>()

        list.add(QuestionModel("What does CPU stand for?", "Central Processing Unit","Computer Programming Unit", "Central Program Utility", "Computer Power Unit","Central Processing Unit"))
        list.add(QuestionModel("Which programming language is commonly used for web development?", "Java","Python", "HTML", "C++","HTML"))
        list.add(QuestionModel("What is the purpose of an operating system?", "To play games","To manage hardware and software resources", "To create documents and spreadsheets", "To browse the internet","To manage hardware and software resources"))
        list.add(QuestionModel("Which storage device provides the fastest data access times?", "Hard Disk Drive (HDD)","Solid State Drive (SSD)", "Blu-ray Disc", "DVD-ROM","Solid State Drive (SSD)"))
        list.add(QuestionModel("Which networking protocol is commonly used to transfer files over the Internet?", "HTTP","FTP", "SMTP", "POP3","FTP"))
        list.add(QuestionModel("What is the binary equivalent of the decimal number 25?", "10010","11001", "10101", "11100","10010"))

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
            intent.putExtra("SCORE2", score)
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