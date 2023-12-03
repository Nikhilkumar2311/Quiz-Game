package com.example.quizgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.quizgame.databinding.ActivityScoreBinding

class ScoreActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScoreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val score: Int
        if (intent.hasExtra("SCORE1")) {
            score = intent.getIntExtra("SCORE1", 0)
        }
        else if (intent.hasExtra("SCORE2")) {
            score = intent.getIntExtra("SCORE2", 0)
        }
        else if (intent.hasExtra("SCORE3")) {
            score = intent.getIntExtra("SCORE3", 0)
        }
        else if (intent.hasExtra("SCORE4")) {
            score = intent.getIntExtra("SCORE4", 0)
        }
        else {
            score = 0
        }

        // Display the score
        binding.score.text = "Congrats!!! Your Score is $score"
    }
}