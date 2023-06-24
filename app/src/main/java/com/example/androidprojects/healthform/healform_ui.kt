package com.example.androidprojects.healthform


import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidprojects.R
import com.google.android.material.button.MaterialButton


class healform_ui : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_healform_ui)
        //button
        val btnhealthdata = findViewById<MaterialButton>(R.id.SubmitButton)
        val btnreset = findViewById<MaterialButton>(R.id.ResetButton)

        //input field by the text field
        var patientname = findViewById<EditText>(R.id.UserNameEdt)
//        var patientsurname = findViewById<EditText>(R.id.UserSurNameEdt)
        var patientmail = findViewById<EditText>(R.id.UserSurEmail)
        var patientnumber = findViewById<EditText>(R.id.UserContact)
        var patientdob = findViewById<EditText>(R.id.UserDob)

        //data showing material text view

        btnhealthdata.setOnClickListener {
//          namev : patientname.getText().toString().trim();


            Toast.makeText(this,"Saved", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@healform_ui, healthdatashow::class.java)
            startActivity(intent)
        }



//        btnhealthdata.setOnClickListener {
//            Toast.makeText(this,"Saved", Toast.LENGTH_SHORT).show()
//            val intent = Intent(this@healform_ui, healthdatashow::class.java)
//            startActivity(intent)
//        }
        btnreset.setOnClickListener {
            patientname.text?.clear()
//            patientsurname.text.clear()
            patientmail.text?.clear()
            patientnumber.text?.clear()
            patientdob.text?.clear()
        }
    }
}