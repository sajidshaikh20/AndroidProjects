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
        var showPname  = findViewById<MaterialTextView>(R.id.edtpatientname)
        var showSname = findViewById<MaterialTextView>(R.id.edtpatientSname)
        var showNum = findViewById<MaterialTextView>(R.id.edtpatientnumber)
        var showdob = findViewById<MaterialTextView>(R.id.edtpatientdob)
        var shhowGender = findViewById<MaterialTextView>(R.id.edtpatientgender)
        var healthissueshw = findViewById<MaterialTextView>(R.id.edtpatientissue)

         var gender : String = intent.getStringExtra("Gender").toString()
         shhowGender.text = gender
         var name : String = intent.getStringExtra("Name_key").toString()
         showPname.text = name
         var Surname : String = intent.getStringExtra("Surname_key").toString()
         showSname.text = Surname
        var Number : String = intent.getStringExtra("contact_key").toString()
        showNum.text = Number
        var dob : String = intent.getStringExtra("Dob_key").toString()
        showdob.text = dob
        var health : String = intent.getStringExtra("health_issue").toString()
        healthissueshw.text = health


    }
}