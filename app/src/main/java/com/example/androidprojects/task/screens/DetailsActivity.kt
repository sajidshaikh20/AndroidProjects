package com.example.androidprojects.task.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import com.example.androidprojects.R
import com.google.android.material.button.MaterialButton

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_activity)

        //button
        val submitbtn = findViewById<MaterialButton>(R.id.SbmtButton)

        //checkbox male and femal

        var Malecheckbox = findViewById<CheckBox>(R.id.malecheckbox)
        var Femalecheckbox  = findViewById<CheckBox>(R.id.femalecheckbox)

        Malecheckbox.setOnCheckedChangeListener { _, isChecked ->
                    if (isChecked) {
                        Femalecheckbox.isChecked = false
                    }
                }
        Femalecheckbox.setOnCheckedChangeListener { _, isChecked ->
                    if (isChecked) {
                        Malecheckbox.isChecked = false
                    }
                }
    }
}