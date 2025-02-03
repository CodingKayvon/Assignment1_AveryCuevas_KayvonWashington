package com.example.assignment1_averycuevas_kayvonwashington

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GradeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grade)

        // Find the views using IDs from XML
        val editTextNumber: EditText = findViewById(R.id.editText)
        val tvGrade: TextView = findViewById(R.id.textView)
        val btnShowGrade: Button = findViewById(R.id.button2)
        val backButton: Button = findViewById(R.id.backbutton)

        // Set the listener for the "Show Grade" button
        btnShowGrade.setOnClickListener {
            // Get the input score from the EditText (as an integer)
            val score = editTextNumber.text.toString().toIntOrNull()

            if (score != null) {
                // Calculate the grade based on the score
                val grade = getGrade(score)
                // Display the grade in the TextView
                tvGrade.text = "Grade: $grade"
            } else {
                // If the user entered an invalid score, show an error message
                tvGrade.text = "Invalid score."
            }
        }

            backButton.setOnClickListener{
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    // Letter grades based on score (given on the assignment)
    private fun getGrade(score: Int): String {
        return when {
            score >= 94 -> "A"
            score in 90..93 -> "A-"
            score in 87..89 -> "B+"
            score in 83..86 -> "B"
            score in 80..82 -> "B-"
            score in 77..79 -> "C+"
            score in 73..76 -> "C"
            score in 70..72 -> "C-"
            else -> "F"
        }
    }
