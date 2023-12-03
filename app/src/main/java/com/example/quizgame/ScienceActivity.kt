package com.example.quizgame

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScienceActivity : AppCompatActivity() {

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
        setContentView(R.layout.activity_science)

        // Initialize the list
        list = ArrayList<QuestionModel>()

        list.add(QuestionModel("What is the chemical symbol for the element oxygen?", "O2", "Ox", "Oc", "O", "O"))
        list.add(QuestionModel("Which planet is known for its beautiful ring system?", "Venus","Earth", "Saturn", "Jupiter","Saturn"))
        list.add(QuestionModel("What is the process by which plants make their own food using sunlight?", "Respiration","Photosynthesis", "Transpiration", "Germination","Photosynthesis"))
        list.add(QuestionModel("What is the smallest unit of matter that retains the properties of an element?", "Cell","Atom", "Molecule", "Proton","Atom"))
        list.add(QuestionModel("Which gas makes up the majority of Earth's atmosphere?", "Oxygen","Carbon dioxide", "Nitrogen", "Hydrogen","Nitrogen"))
        list.add(QuestionModel("What force of nature keeps objects in motion and causes them to fall towards the Earth's surface?", "Magnetic force","Gravitational force", "Electromagnetic force", "Nuclear force","Gravitational force"))

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
            intent.putExtra("SCORE3", score)
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
