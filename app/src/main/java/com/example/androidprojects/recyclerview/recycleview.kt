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
        UserData.add(StudentModel(R.drawable.linkedln_image,"Sajid Shaikh", 25,"Mca" ))
        UserData.add(StudentModel(R.drawable.main_profile2,"Shubham verma", 22, "Bba"))
        UserData.add(StudentModel(R.drawable.post2_demo,"Harshit jalodiya", 20, "bca"))
        UserData.add(StudentModel(R.drawable.shubham,"aashish ", 12, "mca"))
        UserData.add(StudentModel(R.drawable.shubham,"verma sir", 30, "Maths"))
        UserData.add(StudentModel(R.drawable.shubham," ayan shaikh", 23, "m tech"))
        UserData.add(StudentModel(R.drawable.shubham,"faisu shaikh", 24, "tiktok"))
        UserData.add(StudentModel(R.drawable.shubham,"divya patil", 22, "bcom"))
        UserData.add(StudentModel(R.drawable.shubham,"Shubham verma", 27, "patwari"))
        UserData.add(StudentModel(R.drawable.shubham,"praveen singh", 22, "Fresher"))
        val recycleview = findViewById<RecyclerView>(R.id.RecycleView)
        recycleview.layoutManager = LinearLayoutManager(this)
        recycleview.adapter = cardadapter(this,UserData)
    }
}