package com.example.quizgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizgame.databinding.ActivityComputerBinding
import com.example.quizgame.databinding.ActivityScienceBinding

class ScienceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScienceBinding
    private lateinit var list: ArrayList<QuestionModel>
    private var count: Int = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScienceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize the list
        list = ArrayList<QuestionModel>()

        list.add(QuestionModel("What is the chemical symbol for the element oxygen?", "O2","Ox", "Oc", "O","O"))
        list.add(QuestionModel("Which planet is known for its beautiful ring system?", "Venus","Earth", "Saturn", "Jupiter","Saturn"))
        list.add(QuestionModel("What is the process by which plants make their own food using sunlight?", "Respiration","Photosynthesis", "Transpiration", "Germination","Photosynthesis"))
        list.add(QuestionModel("What is the smallest unit of matter that retains the properties of an element?", "Cell","Atom", "Molecule", "Proton","Atom"))
        list.add(QuestionModel("Which gas makes up the majority of Earth's atmosphere?", "Oxygen","Carbon dioxide", "Nitrogen", "Hydrogen","Nitrogen"))
        list.add(QuestionModel("What force of nature keeps objects in motion and causes them to fall towards the Earth's surface?", "Magnetic force","Gravitational force", "Electromagnetic force", "Nuclear force","Gravitational force"))

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
            intent.putExtra("SCORE3", score)
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