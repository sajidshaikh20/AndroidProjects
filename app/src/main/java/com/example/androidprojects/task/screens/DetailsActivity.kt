package com.example.androidprojects.task.screens

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.CheckBox
import android.widget.DatePicker
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidprojects.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.util.Calendar
import java.util.Locale
import java.util.regex.Matcher
import java.util.regex.Pattern

class DetailsActivity : AppCompatActivity() {
    lateinit var userName: TextInputEditText
    lateinit var userMail: TextInputEditText
    lateinit var userNum: TextInputEditText
    lateinit var userDob: TextInputEditText
    lateinit var userPass: TextInputEditText
    lateinit var userConPass: TextInputEditText


    lateinit var maleCheckbox: RadioButton
    lateinit var femaleCheckbox: RadioButton
    lateinit var chessCheckBox: CheckBox
    lateinit var cookCheckBox: CheckBox
    lateinit var travelCheckBox: CheckBox
    lateinit var danceCheckBox: CheckBox
    lateinit var Doblayout: TextInputLayout

//    var isAllFieldsChecked = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_activity)
        var isAllFieldsChecked = false

        //find edit text
        userName = findViewById(R.id.NameTextField)
        userMail = findViewById(R.id.mailTextField)
        userNum = findViewById(R.id.contactTextField)
        userDob = findViewById(R.id.UserDobTextfield)
        userPass = findViewById(R.id.userPassword)
        userConPass = findViewById(R.id.confirmPassword)

        //check box male and female
        maleCheckbox = findViewById(R.id.malecheckbox)
        femaleCheckbox = findViewById(R.id.femalecheckbox)
        //checkbox situation handle false and true one time pe sirf one slection code
        chessCheckBox = findViewById(R.id.cbChess)
        cookCheckBox = findViewById(R.id.cbcook)
        travelCheckBox = findViewById(R.id.cbTravel)
        danceCheckBox = findViewById(R.id.cbDance)
//        val userName = findViewById<TextInputEditText>(R.id.NameTextField)
//        val userMail = findViewById<TextInputEditText>(R.id.mailTextField)
//        val userNum = findViewById<TextInputEditText>(R.id.contactTextField)
//        val userDob = findViewById<TextInputEditText>(R.id.UserDobTextfield)
//        val userPass = findViewById<TextInputEditText>(R.id.userPassword)
//        val userConPass = findViewById<TextInputEditText>(R.id.confirmPassword)

        //button
        val submitBtn = findViewById<MaterialButton>(R.id.SbmtButton)
    Doblayout = findViewById(R.id.Doblayout)
//    userDob.isEnabled = true
    Doblayout.setStartIconOnClickListener {
        showDatePickerDialog()
    }

//        maleCheckbox.setOnCheckedChangeListener { _, isChecked ->
//            if (isChecked) {
//                femaleCheckbox.isChecked = false
//            }
//        }
//        femaleCheckbox.setOnCheckedChangeListener { _, isChecked ->
//            if (isChecked) {
//                maleCheckbox.isChecked = false
//            }
//        }


        //set one time pe one selection
//        .ed) {
//                cookCheckBox.isChecked = false
//                travelCheckBox.isChecked = false
//                danceCheckBox.isChecked = false
//            }
//        }
//        cookCheckBox.setOnCheckedChangeListener { _, isChecked ->
//            if (isChecked) {
//                chessCheckBox.isChecked = false
//                travelCheckBox.isChecked = false
//                danceCheckBox.isChecked = false
//            }
//        }
//        travelCheckBox.setOnCheckedChangeListener { _, isChecked ->
//            if (isChecked) {
//                chessCheckBox.isChecked = false
//                cookCheckBox.isChecked = false
//                danceCheckBox.isChecked = false
//            }
//        }
//        danceCheckBox.setOnCheckedChangeListener { _, isChecked ->
//            if (isChecked) {
//                chessCheckBox.isChecked = false
//                cookCheckBox.isChecked = false
//                travelCheckBox.isChecked = false
//            }
//        }

        //submit button
        submitBtn.setOnClickListener {
           // val intent = Intent()

            isAllFieldsChecked = CheckAllFields()
            if (isAllFieldsChecked){
                val validPass = isValidPass(userPass.text.toString()) == null
                val validEmail = isValidEmail(userMail.text.toString()) == true
                val validNum = isValidNum(userNum.text.toString()) == true
                val validGen = isGenderSelect() == true
                val validHobie =   isHobiesselect() == true
                if (validPass && validEmail && validNum && userPass.text.toString() == userConPass.text.toString() && validGen && validHobie  ) {
                    validForm()
                } else {
                    inValidForm()
                }

            }

        }
    }

    private fun isValidEmail(email: String): Boolean {
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

    private fun isValidNum(number: String): Boolean {

        if (!number.matches(".*[0-9].*".toRegex())) {
            return false
        }
        return true
    }

    private  fun isGenderSelect() : Boolean{

        if(maleCheckbox.isChecked== false && femaleCheckbox.isChecked==false)
        {
            return false
        }
        return  true
    }
    private fun isHobiesselect(): Boolean{

        if(chessCheckBox.isChecked ==false && cookCheckBox.isChecked == false && travelCheckBox.isChecked == false && danceCheckBox.isChecked== false)
        {
            return false
        }
        return  true
    }



    private fun isValidPass(password: String): String? {

        if (password.length < 8) {
            return "Minimum 8 Character Password"
        }
        if (!password.matches(".*[A-Z].*".toRegex())) {
            return "Must Contain 1 Upper-case Character"
        }
        if (!password.matches(".*[a-z].*".toRegex())) {
            return "Must Contain 1 Lower-case Character"
        }
        if (!password.matches(".*[@#\$%^&+=].*".toRegex())) {
            return "Must Contain 1 Special Character (@#\$%^&+=)"
        }
        return null
    }

    private fun validForm() {

        Toast.makeText(this, "Form Submitted", Toast.LENGTH_SHORT).show()
        val intent = Intent()
        intent.putExtra("Name_key", userName.text.toString())
        intent.putExtra("Mail_key", userMail.text.toString())
        intent.putExtra("Con_key", userNum.text.toString())
        intent.putExtra("Dob_key", userDob.text.toString())
        intent.putExtra("Pass_key", userPass.text.toString())
        intent.putExtra("Cpass_key", userConPass.text.toString())

        intent.putExtra("Male_key", "")
        intent.putExtra("Female_key", "")
        if (maleCheckbox.isChecked) {
            intent.putExtra("Male_key", maleCheckbox.text.toString())
        }
        if (femaleCheckbox.isChecked) {
            intent.putExtra("Female_key", femaleCheckbox.text.toString())
        }
        intent.putExtra("Chess_key", "")
        intent.putExtra("Cook_key", "")
        intent.putExtra("Travel_key", "")
        intent.putExtra("Dance_key", "")

        if (chessCheckBox.isChecked) {
            intent.putExtra("Chess_key", chessCheckBox.text.toString())
        }
        if (cookCheckBox.isChecked) {
            intent.putExtra("Cook_key", cookCheckBox.text.toString())
        }
        if (travelCheckBox.isChecked) {
            intent.putExtra("Travel_key", travelCheckBox.text.toString())
        }
        if (danceCheckBox.isChecked) {
            intent.putExtra("Dance_key", danceCheckBox.text.toString())
        }
        setResult(RESULT_OK, intent);
        finish()
    }
    private fun inValidForm() {
        Toast.makeText(this, "All Field Required", Toast.LENGTH_SHORT).show()
    }
    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        Log.i("CalenderValue" ,"calender")
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this,
            { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDay: Int ->
                val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                userDob.setText(selectedDate)
            }, year , month,day
        )
        datePickerDialog.datePicker.maxDate = System.currentTimeMillis()
        datePickerDialog.show()
    }
    private fun CheckAllFields(): Boolean {
        if (userName.length() == 0) {
            userName.error= "Name is required"
            return false
        }
        if (userMail.length() == 0) {
            userMail.setError("Email is required")
            return false
        }
        if (userNum.length() == 0) {
            userNum.setError("Number is Required")
            return false
        }
         if(userDob.length() ==0){
             userDob.setError("Dob is Required")
         }
        if (userPass.length() == 0) {

            Toast.makeText(this, "Password is Required", Toast.LENGTH_SHORT).show()
//            userPass.setError("Password is required")
            return false
        } else if (userPass.length() < 8) {
            Toast.makeText(this, "Password must be minimum 8 characters", Toast.LENGTH_SHORT).show()
//            userPass.setError ("Password must be minimum 8 characters")
            return false
        }
        if(userPass.text.toString() != userConPass.text.toString()){
            Toast.makeText(this, "Confirm Password is Must Same", Toast.LENGTH_SHORT).show()
//            userConPass.setError("Confirm Password is Must Same")
        }


//            if (maleCheckbox.isChecked ==false && femaleCheckbox.isChecked ==false){
//                maleCheckbox.error = ""
//            }

        // after all validation return true.
        return true
    }
}







