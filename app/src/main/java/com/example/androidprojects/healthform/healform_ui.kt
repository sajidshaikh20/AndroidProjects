package com.example.androidprojects.healthform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.androidprojects.R
import com.example.androidprojects.peramids.peramids_riversed
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class healform_ui : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_healform_ui)
        val btnhealthdata = findViewById<MaterialButton>(R.id.SubmitButton)
        val patientname = findViewById<EditText>(R.id.UserNameEdt)
        val patientsurname = findViewById<EditText>(R.id.UserSurNameEdt)
        val patientmail = findViewById<EditText>(R.id.UserSurEmail)
        val patientnumber = findViewById<EditText>(R.id.UserContact)
        val patientdob = findViewById<EditText>(R.id.UserDob)


        btnhealthdata.setOnClickListener {
            val intent = Intent(this, healthdatashow::class.java)
            startActivity(intent)
        }
    }
}