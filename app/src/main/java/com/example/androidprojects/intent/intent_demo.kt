package com.example.androidprojects.intent


import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidprojects.R
import com.google.android.material.button.MaterialButton

class intent_demo : AppCompatActivity() {

        lateinit var btndial : MaterialButton
        lateinit var btngmail : MaterialButton
        lateinit var  btnweb : MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_demo)

        btndial = findViewById(R.id.actiondial)
        btngmail = findViewById(R.id.actiongmail)
        btnweb = findViewById(R.id.actionweb)


        btndial.setOnClickListener {
             val phoneNo = "7415311601"
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$phoneNo")
            startActivity(intent)
        }
        btngmail.setOnClickListener {
            val Gmail = "sajid20shaikh@gmail.com"
            val intent = Intent(Intent.ACTION_SEND)
            intent.data = Uri.parse("send")
            startActivity(intent)
        }
        btnweb.setOnClickListener{
            val web = "www.google.com"
            val intent = Intent(Intent.ACTION_WEB_SEARCH)
            intent.putExtra(SearchManager.QUERY, web)
            startActivity(intent)

        }


    }
}