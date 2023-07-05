package com.example.androidprojects.task.screens

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Patterns
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidprojects.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import java.util.Locale
import java.util.regex.Matcher
import java.util.regex.Pattern

class DetailsActivity : AppCompatActivity() {



    lateinit var userName :TextInputEditText
    lateinit var userMail :TextInputEditText
    lateinit var userNum :TextInputEditText
    lateinit var userDob :TextInputEditText
    lateinit var userPass :TextInputEditText
    lateinit var userConPass :TextInputEditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_activity)
        var isAllFieldsChecked = false

        //find edit text
        userName = findViewById<TextInputEditText>(R.id.NameTextField)
         userMail = findViewById<TextInputEditText>(R.id.mailTextField)
         userNum = findViewById<TextInputEditText>(R.id.contactTextField)
         userDob = findViewById<TextInputEditText>(R.id.UserDobTextfield)
         userPass = findViewById<TextInputEditText>(R.id.userPassword)
         userConPass = findViewById<TextInputEditText>(R.id.confirmPassword)


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


        //submit button
        submitBtn.setOnClickListener {


        val    validPass = isValidPass(userPass.text.toString())==null
        val   validEmail = isValidEmail(userMail.text.toString())==true
            val validNum = isValidNum(userNum.text.toString())==true
            if (validPass && validEmail && validNum && userPass.text.toString()==userConPass.text.toString()){
     validForm()


            }else{
                inValidForm()
            }

        }
    }

 private   fun isValidEmail(email: String): Boolean {
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

  private fun isValidNum(number: String): Boolean{

      if(!number.matches(".*[0-9].*".toRegex())){
          return false
      }
      return true
  }
  private  fun isValidPass(password: String): String?{


      if(password.length < 8)
      {
          return "Minimum 8 Character Password"
      }
      if(!password.matches(".*[A-Z].*".toRegex()))
      {
          return "Must Contain 1 Upper-case Character"
      }
      if(!password.matches(".*[a-z].*".toRegex()))
      {
          return "Must Contain 1 Lower-case Character"
      }
      if(!password.matches(".*[@#\$%^&+=].*".toRegex()))
      {
          return "Must Contain 1 Special Character (@#\$%^&+=)"
      }
      return null

  }
  private fun validForm(){

      Toast.makeText(this,"Form Submitted", Toast.LENGTH_SHORT).show()

      val intent = Intent()

                intent.putExtra("Name_key", userName.text.toString())
                intent.putExtra("Mail_key", userMail.text.toString())
                intent.putExtra("Con_key", userNum.text.toString())
                setResult(RESULT_OK, intent);
                finish()
  }
    private fun inValidForm(){
        Toast.makeText(this,"Invalid Form", Toast.LENGTH_SHORT).show()
    }



}