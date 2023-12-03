package com.example.quizgame

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {

    private lateinit var scoreTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        scoreTextView = findViewById(R.id.score)

        val score: Int = when {
            intent.hasExtra("SCORE1") -> intent.getIntExtra("SCORE1", 0)
            intent.hasExtra("SCORE2") -> intent.getIntExtra("SCORE2", 0)
            intent.hasExtra("SCORE3") -> intent.getIntExtra("SCORE3", 0)
            intent.hasExtra("SCORE4") -> intent.getIntExtra("SCORE4", 0)
            else -> 0
        }

        // Display the score
        scoreTextView.text = "Congrats!!! Your Score is $score"
    }
}
