package com.example.androidprojects.task.screens

import android.annotation.SuppressLint
import android.content.AbstractThreadedSyncAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidprojects.R
import com.example.androidprojects.recyclerview.model.StudentModel
import com.example.androidprojects.task.adapter.UserCardAdapter
import com.example.androidprojects.task.model.UserModel
import com.example.androidprojects.task.model.interfaceClass.DetailsInterface
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView


class HomePage : AppCompatActivity(),DetailsInterface {
    lateinit var recyclerView: RecyclerView
    val userData = ArrayList<UserModel>()
    lateinit var adapter : UserCardAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_task_activity)
        recyclerView = findViewById(R.id.rcvUserData)


//        val showUserName  = findViewById<MaterialTextView>(R.id.NameTextField)
//        val showUserMail  = findViewById<MaterialTextView>(R.id.edtUserMail)
//        val showUserNum  = findViewById<MaterialTextView>(R.id.edtUserNumber)



        //data.add(UserModel("sajid","7415316414","sajid20shaikh@gmail.com"))
        adapter=UserCardAdapter(this, userData, this@HomePage)
        recyclerView.adapter = adapter

        // assin url and find profile where show the image
        val purl = "https://cdn.pixabay.com/photo/2023/06/21/15/07/butterfly-8079524_640.jpg"
        val profile_Img = findViewById<ShapeableImageView>(R.id.profile_img)
      
        // fetch image through url
        Glide.with(this)
            .load(purl)
            .centerCrop()
            .into(profile_Img)





      // flaoting action button
        val fab_btn = findViewById<FloatingActionButton>(R.id.fab_btn)
        fab_btn.setOnClickListener {
            val intent = Intent(this, DetailsActivity::class.java)
            startActivityForResult(intent,100)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == RESULT_OK){
        userData.add(
            UserModel(data?.getStringExtra("Name_key").toString(),
            data?.getStringExtra("Mail_key").toString(),
            data?.getStringExtra("Con_key").toString(),
            data?.getStringExtra("Dob_key").toString(),
            data?.getStringExtra("Pass_key").toString(),
            data?.getStringExtra("Cpass_key").toString(),
            data?.getStringExtra("Male_key").toString(),
            data?.getStringExtra("Female_key").toString(),
            data?.getStringExtra("Chess_key").toString(),
            data?.getStringExtra("Cook_key").toString(),
            data?.getStringExtra("Travel_key").toString(),
            data?.getStringExtra("Dance_key").toString(),
        ))
            adapter.notifyItemChanged( userData.size)
        }
    }
    override fun getDetails(
        name: String,
        mail: String,
        number: String,
        dob: String,
        male: String,
        female: String,
        chess: String,
        cook: String,
        travel: String,
        dance: String
    ) {
        val intent = Intent(this, ShowDetailsActivity::class.java)
        intent.putExtra("name", name)
        intent.putExtra("mail", mail)
        intent.putExtra("number", number)
        intent.putExtra("dob", dob)
        intent.putExtra("male", male)
        intent.putExtra("female", female)
        intent.putExtra("chess", chess)
        intent.putExtra("cook", cook)
        intent.putExtra("travel", travel)
        intent.putExtra("dance", dance)
        startActivity(intent)
    }
}