package com.example.androidprojects.healthform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidprojects.R
import com.google.android.material.textview.MaterialTextView

class healthdatashow : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_healthdatashow)
        var showPname  = findViewById<MaterialTextView>(R.id.edtpatientname)
        var showNum = findViewById<MaterialTextView>(R.id.edtpatientnumber)
        var showdob = findViewById<MaterialTextView>(R.id.edtpatientdob)
        var shhowGender = findViewById<MaterialTextView>(R.id.edtpatientgender)

    }
}