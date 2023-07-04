package com.example.androidprojects.intent


import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidprojects.R
import com.google.android.material.button.MaterialButton
import java.util.Locale
import java.util.regex.Matcher
import java.util.regex.Pattern


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
        btnweb = findViewById(R.id.webbutton)
        contactinput = findViewById(R.id.actiondial)
        mailinput  = findViewById(R.id.actiongmail)
        btngmail = findViewById(R.id.Gmailaction)
        webinput  = findViewById(R.id.actionweb)

        btndial.setOnClickListener {
         val cntct = contactinput.text.toString()
             val phoneNo = cntct
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$phoneNo")
            startActivity(intent)
        }
        btngmail.setOnClickListener {
            val Gmail = mailinput.text.toString()
            val intent = Intent(Intent.ACTION_SENDTO)

            if (isValidEmail(Gmail) && Gmail.length > 0)
            {
                Toast.makeText(this,"valid mail", Toast.LENGTH_SHORT).show()
                intent.data = Uri.parse("mailto:$Gmail")
                startActivity(intent)
            }
            else
            {
                Toast.makeText(this,"Invalid mail", Toast.LENGTH_SHORT).show()
            }

            
        }
        btnweb.setOnClickListener{
            val baseurl = webinput.text.toString()
            isValidUrl(baseurl)
            if(isValidUrl(baseurl)){
                val intent = Intent(Intent.ACTION_WEB_SEARCH)
                intent.putExtra(SearchManager.QUERY, "https://www.$baseurl.com")
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"Wrong url", Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun isValidEmail(email: String): Boolean {
        var isValidEmail = false
        val emailExpression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val inputStr: CharSequence = email
        val pattern: Pattern = Pattern.compile(emailExpression, Pattern.CASE_INSENSITIVE)
        val matcher: Matcher = pattern.matcher(inputStr)
        if (matcher.matches()) {
            isValidEmail = true
        }
        return isValidEmail
    }
    private fun isValidUrl(url: String): Boolean {
        val p = Patterns.WEB_URL
        val m = p.matcher(url.lowercase(Locale.getDefault()))
        return m.matches()
    }
}