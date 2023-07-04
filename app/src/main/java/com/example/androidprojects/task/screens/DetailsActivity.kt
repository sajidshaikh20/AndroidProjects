package com.example.androidprojects.task.screens

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import com.example.androidprojects.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import java.util.Locale

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_activity)
        var isAllFieldsChecked = false

        //find edit text
        val userName = findViewById<TextInputEditText>(R.id.NameTextField)
        val userMail = findViewById<TextInputEditText>(R.id.mailTextField)
        val userNum = findViewById<TextInputEditText>(R.id.contactTextField)

        //button
        val submitBtn = findViewById<MaterialButton>(R.id.SbmtButton)

        //checkbox male and female
        val maleCheckbox = findViewById<CheckBox>(R.id.malecheckbox)
        val femaleCheckbox = findViewById<CheckBox>(R.id.femalecheckbox)
        maleCheckbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                femaleCheckbox.isChecked = false
            }
        }
        femaleCheckbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                maleCheckbox.isChecked = false
            }
        }
        //checkbox situation handle false and true one time pe sirf one slection code
        val chessCheckBox = findViewById<CheckBox>(R.id.cbChess)
        val cookCheckBox = findViewById<CheckBox>(R.id.cbcook)
        val travelCheckBox = findViewById<CheckBox>(R.id.cbTravel)
        val danceCheckBox = findViewById<CheckBox>(R.id.cbDance)

        //set one time pe one selection
        chessCheckBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                cookCheckBox.isChecked = false
                travelCheckBox.isChecked = false
                danceCheckBox.isChecked = false
            }
        }
        cookCheckBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                chessCheckBox.isChecked = false
                travelCheckBox.isChecked = false
                danceCheckBox.isChecked = false
            }
        }
        travelCheckBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                chessCheckBox.isChecked = false
                cookCheckBox.isChecked = false
                danceCheckBox.isChecked = false
            }
        }
        danceCheckBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                chessCheckBox.isChecked = false
                cookCheckBox.isChecked = false
                travelCheckBox.isChecked = false
            }
        }

+-
        //submit button
        submitBtn.setOnClickListener {

                val intent = Intent()
                intent.putExtra("Name_key", userName.text.toString())
                intent.putExtra("Mail_key", userMail.text.toString())
                intent.putExtra("Con_key", userNum.text.toString())
                setResult(RESULT_OK, intent);
                finish()
        }
    }

}