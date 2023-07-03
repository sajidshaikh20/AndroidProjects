package com.example.androidprojects.task.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.androidprojects.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.imageview.ShapeableImageView

class homepage : AppCompatActivity() {
  
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_task_activity)
        // assin url and find profile where show the image
        val purl = "https://cdn.pixabay.com/photo/2023/06/21/15/07/butterfly-8079524_640.jpg"
        val profile_Img = findViewById<ShapeableImageView>(R.id.profile_img)
      
        // fetch image through url
        Glide.with(this)
            .load(purl)
            .centerCrop()
            .into(profile_Img)
        
        
        // 
        val fab_btn = findViewById<FloatingActionButton>(R.id.fab_btn)
        fab_btn.setOnClickListener {
            val intent = Intent(this, DetailsActivity::class.java)
            startActivity(intent)
        }
        
    }
}