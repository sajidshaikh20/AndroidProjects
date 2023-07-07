package com.example.androidprojects.fragmentDemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidprojects.R

class MainFragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragment)
    }
}