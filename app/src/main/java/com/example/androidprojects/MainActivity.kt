package com.example.androidprojects

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidprojects.healthform.healform_ui
import com.example.androidprojects.instagram.instagram_ui
import com.example.androidprojects.intent.intent_demo
import com.example.androidprojects.linkedln.linkedln_ui
import com.example.androidprojects.patterns.patterns
import com.example.androidprojects.peramids.peramids_riversed
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val nextinsta = findViewById<MaterialButton>(R.id.instagrambtn)
        val nextPelindrom = findViewById<MaterialButton>(R.id.Pelindromebtn)
        val  nextpattern = findViewById<MaterialButton>(R.id.patternbtn)
        val nexthealthform = findViewById<MaterialButton>(R.id.healthformbtn)
        val nextlinkedln = findViewById<MaterialButton>(R.id.linkedlnbtn)
        val nextintent = findViewById<MaterialButton>(R.id.intentsbtn)
        nextinsta.setOnClickListener {
//            val navigatedemo = "Enter"
            callActivity()
        }
        nextPelindrom.setOnClickListener {
            val intent = Intent(this,peramids_riversed::class.java)
            startActivity(intent)
        }
        nextpattern.setOnClickListener {
            val  intent = Intent(this,patterns::class.java)
            startActivity(intent)
        }
        nexthealthform.setOnClickListener {
            val intent = Intent(this,healform_ui::class.java)
            startActivity(intent)
        }
        nextlinkedln.setOnClickListener {
            val intent = Intent(this,linkedln_ui::class.java)
            startActivity(intent)
        }
        nextintent.setOnClickListener {
            val intent = Intent(this,intent_demo::class.java)
            startActivity(intent)
        }


    }

    private fun callActivity() {
        val intent = Intent(this,instagram_ui::class.java)
        startActivity(intent)
    }

}