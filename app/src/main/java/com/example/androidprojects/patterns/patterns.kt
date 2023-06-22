package com.example.androidprojects.patterns

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.TextView

import com.example.androidprojects.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText


class patterns : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patterns)
        val btnperamid = findViewById<MaterialButton>(R.id.Peramids)
        val input = findViewById<TextInputEditText>(R.id.editText)
        val textViewshow = findViewById<TextView>(R.id.textView)
        val btntriangle = findViewById<MaterialButton>(R.id.triangle)
        btnperamid.setOnClickListener {
            val inputText = input.text.toString()
            if (inputText.isNotBlank()) {
                val ans = inputText.toInt()
                val peramidAns = StringBuilder()
                for (i in 1..ans) {
                    for (k in i until ans) {
                        peramidAns.append(" ")
                    }
                    for (j in 1..i) {
                        peramidAns.append("$j ")
                    }
                    peramidAns.append("\n")
                }
                textViewshow.text = peramidAns.toString()
            }
        }
        btntriangle.setOnClickListener {
            val inputText = input.text.toString()


        }
    }
}
//val ans = input.text.toString().toInt()
//val triangle = StringBuilder()
//for(i in 1 until ans){
//    for(j in 1 until i){
//        triangle.append(j)
//    }
//    triangle.append("\n")
//}
//ans2.text = triangle;