package com.example.androidprojects.peramids

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.androidprojects.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class peramids_riversed : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peramids_riversed)
        val textfield = findViewById<TextInputEditText>(R.id.textfield)
        val btnSubmit = findViewById<MaterialButton>(R.id.btnSubmit)
        val textview  = findViewById<TextView>(R.id.textViewAnser)
        val btnReset = findViewById<MaterialButton>(R.id.Btnreset)
        val btnpelindrome = findViewById<MaterialButton>(R.id.btnpellindrome)


        //button handler
        btnSubmit.setOnClickListener {
            val strRiverse = textfield.text.toString().reversed()
            textview.text = strRiverse

            Toast.makeText(this,strRiverse, Toast.LENGTH_SHORT).show()
        }
        //reset button handler
        btnReset.setOnClickListener {
            textfield.text?.clear()
            textview.text = ""
        }
        // palindorme button handle
        btnpelindrome.setOnClickListener {
            var res = ""
            var input = textfield.text.toString().toLowerCase()
            for(i in input){
                res = i+res
            }
            val strRiverse = res
//            textview.text = strRiverse
            if(strRiverse==input){
                textview.text = "Given string or number is pelindrome"
                Toast.makeText(this,strRiverse, Toast.LENGTH_SHORT).show()
            }else{
                textview.text = "Not pelindrome"
            }
        }
    }
}