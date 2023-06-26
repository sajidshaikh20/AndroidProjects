package com.example.androidprojects.healthform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.androidprojects.R
import com.google.android.material.textview.MaterialTextView

class healthdatashow : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_healthdatashow)
        val showPname  = findViewById<MaterialTextView>(R.id.edtpatientname)
        val showSname = findViewById<MaterialTextView>(R.id.edtpatientSname)
        val showNum = findViewById<MaterialTextView>(R.id.edtpatientnumber)
        val showdob = findViewById<MaterialTextView>(R.id.edtpatientdob)
        val shhowGender = findViewById<MaterialTextView>(R.id.edtpatientgender)
        val healthissueshw = findViewById<MaterialTextView>(R.id.edtpatientissue)

         val gender : String = intent.getStringExtra("Gender").toString()
         shhowGender.text = gender
         val name : String = intent.getStringExtra("Name_key").toString()
         showPname.text = name
         val Surname : String = intent.getStringExtra("Surname_key").toString()
         showSname.text = Surname
        val Number : String = intent.getStringExtra("contact_key").toString()
        showNum.text = Number
        val dob : String = intent.getStringExtra("Dob_key").toString()
        showdob.text = dob
        val health : String = intent.getStringExtra("health_issue").toString()
        healthissueshw.text = health
    }
}