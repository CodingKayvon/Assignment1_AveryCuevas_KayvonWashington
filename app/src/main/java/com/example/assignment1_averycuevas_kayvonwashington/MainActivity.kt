package com.example.assignment1_averycuevas_kayvonwashington

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var l: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        l = findViewById(R.id.list)

        // Grabs the array from strings.xml
        val userInfo = resources.getStringArray(R.array.user_info)
        // Creates an ArrayAdapter using userinfo array
        val arr: ArrayAdapter<String> = ArrayAdapter(
            this,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
            userInfo
        )
        l.adapter = arr

        // Grade button by ID
        val gradeButton: Button = findViewById(R.id.button)

        // Use an onClickListener to get to GradeActivity
        gradeButton.setOnClickListener {
            val intent = Intent(this, GradeActivity::class.java)
            startActivity(intent)
        }
    }
}