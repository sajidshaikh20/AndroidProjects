package com.example.androidprojects.task.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidprojects.R
import com.google.android.material.textview.MaterialTextView

class ShowDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_details)
        val nameshow  = findViewById<MaterialTextView>(R.id.mtvNameShow)
        val mailshow  = findViewById<MaterialTextView>(R.id.mtvMailShow)
        val numbershow  = findViewById<MaterialTextView>(R.id.mtvNumShow)
        val dobshow  = findViewById<MaterialTextView>(R.id.mtvDobShow)
        val gendershow  = findViewById<MaterialTextView>(R.id.mtvGenderShow)

//        val chessshow  = findViewById<MaterialTextView>(R.id.mtvChessShow)
//        val cookshow  = findViewById<MaterialTextView>(R.id.mtvCookShow)
//        val travelshow  = findViewById<MaterialTextView>(R.id.mtvTravelShow)
//        val danceshow  = findViewById<MaterialTextView>(R.id.mtvDanceShow)


        nameshow.text = intent.getStringExtra("name")
        mailshow.text = intent.getStringExtra("mail")
        numbershow.text = intent.getStringExtra("number")
        dobshow.text = intent.getStringExtra("dob")

        if(intent.getStringExtra("male")=="Male"){

            gendershow.text = intent.getStringExtra("male")
        }
        if(intent.getStringExtra("female")=="Female"){

            gendershow.text = intent.getStringExtra("female")
        }

//        chessshow.text = intent.getStringExtra("chess")
//        cookshow.text = intent.getStringExtra("cook")
//        travelshow.text = intent.getStringExtra("travel")
//        danceshow.text = intent.getStringExtra("dance")

    }
}

