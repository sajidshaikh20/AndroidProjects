package com.example.androidprojects.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.UserData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidprojects.R
import com.example.androidprojects.recyclerview.adapter.cardadapter
import com.example.androidprojects.recyclerview.model.StudentModel

class recycleview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycleview)
        var UserData = ArrayList<StudentModel>()
        UserData.add(StudentModel(R.drawable.linkedln_image,"sajid shaik", 25,"Mca" ))

        val recycleview = findViewById<RecyclerView>(R.id.RecycleView)
        recycleview.layoutManager = LinearLayoutManager(this)
        recycleview.adapter = cardadapter(this,UserData)




    }
}