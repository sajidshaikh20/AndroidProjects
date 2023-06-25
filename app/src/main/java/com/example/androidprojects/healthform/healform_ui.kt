package com.example.androidprojects.healthform


import android.content.Intent
import android.os.Bundle
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidprojects.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class healform_ui : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_healform_ui)
        //button
        val btnhealthdata = findViewById<MaterialButton>(R.id.SubmitButton)
        val btnreset = findViewById<MaterialButton>(R.id.ResetButton)

        //input field by the text field
        var patientname = findViewById<TextInputEditText>(R.id.UserNameEdt)
        var patientsurname = findViewById<TextInputEditText>(R.id.UserSurNameEdt)
        var patientmail = findViewById<TextInputEditText>(R.id.UserSurEmail)
        var patientnumber = findViewById<TextInputEditText>(R.id.UserContact)
        var patientdob = findViewById<EditText>(R.id.UserDob)

        //data showing material text view

        var checkBoxmale = findViewById<CheckBox>(R.id.checkBoxM)
        var checkBoxFemale  = findViewById<CheckBox>(R.id.checkBoxF)


        // fever check box find view id se
        var checkBoxfever = findViewById<CheckBox>(R.id.checkBoxFever)
        var checkBoxmaleria = findViewById<CheckBox>(R.id.checkBoxMaleria)
        var checkbocother  = findViewById<CheckBox>(R.id.checkBoxother)


        // gender check box
        checkBoxmale.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                checkBoxFemale.isChecked = false
            }
        }
        checkBoxFemale.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                checkBoxmale.isChecked = false
            }
        }
     //health issue check
        checkBoxfever.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                checkBoxmaleria.isChecked = false
                checkbocother.isChecked = false
            }
        }

        checkBoxmaleria.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                checkBoxfever.isChecked = false
                checkbocother.isChecked = false
            }
        }

        checkbocother.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                checkBoxfever.isChecked = false
                checkBoxmaleria.isChecked = false
            }
        }

        btnhealthdata.setOnClickListener {
//          namev : patientname.getText().toString().trim();

            val nameshow: String = patientname.text.toString()

            val surnameshow: String = patientsurname.text.toString()

            val numbershow: String = patientnumber.getText().toString()

            val dobshow : String = patientdob.getText().toString()
//            intent.putExtra("dob",)

            Toast.makeText(this,"Saved", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@healform_ui, healthdatashow::class.java)

          // male or female selection if else
            if (checkBoxmale.isChecked){
                intent.putExtra("Gender","Male")
            }
            else if (checkBoxFemale.isChecked){
                intent.putExtra("Gender","Female")
            } else{
                intent.putExtra("Gender", "other")
            }




           // health issue health selection
            if (checkBoxfever.isChecked){
                intent.putExtra("health_issue", "Fever")
            } else if (checkBoxmaleria.isChecked){
                intent.putExtra("health_issue", "Maleria")
            } else if (checkbocother.isChecked){
                intent.putExtra("health_issue", "Other")
            }else{
                intent.putExtra("health_issue", "Other")
            }
            intent.putExtra("Name_key", nameshow)
            intent.putExtra("Surname_key", surnameshow)
            intent.putExtra("contact_key", numbershow)
            intent.putExtra("Dob_key",dobshow)
            startActivity(intent)
        }
        btnreset.setOnClickListener {
            checkBoxmale.isChecked
            patientname.text?.clear()
            patientsurname.text?.clear()
            patientmail.text?.clear()
            patientnumber.text?.clear()
            patientdob.text?.clear()
        }
    }




}