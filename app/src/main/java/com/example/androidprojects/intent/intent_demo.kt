package com.example.androidprojects.intent


import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.widget.AppCompatEditText
import com.example.androidprojects.R
import com.google.android.material.button.MaterialButton

class intent_demo : AppCompatActivity() {

        lateinit var btndial : MaterialButton
        lateinit var btngmail : MaterialButton
        lateinit var  btnweb : MaterialButton
        lateinit var   contactinput : EditText
        lateinit var  mailinput : EditText
        lateinit var  webinput : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_demo)

        btndial = findViewById(R.id.Dialbutton)
        btngmail = findViewById(R.id.Gmailaction)
        btnweb = findViewById(R.id.webbutton)
       contactinput = findViewById(R.id.actiondial)
        mailinput  = findViewById(R.id.actiongmail)
        webinput  = findViewById(R.id.actionweb)

        btndial.setOnClickListener {
         val cntct = contactinput.text.toString()
             val phoneNo = cntct
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$phoneNo")
            startActivity(intent)
        }
        btngmail.setOnClickListener {
            val Gmail = contactinput.text.toString()
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:$Gmail")
            startActivity(intent)
        }
        btnweb.setOnClickListener{
            var baseurl = webinput.text.toString()
            val intent = Intent(Intent.ACTION_WEB_SEARCH)
            intent.putExtra(SearchManager.QUERY, "https://www.$baseurl.com")
            startActivity(intent)
        }
    }
}