package com.example.androidprojects.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidprojects.R
import com.example.androidprojects.recyclerview.model.StudentModel
import com.google.android.material.textview.MaterialTextView


class cardadapter(
    val requireContex : Context,
    val carddetailsdata : ArrayList<StudentModel>
) : RecyclerView.Adapter<cardadapter.cardviewdata>() {

    class cardviewdata(itemView : View) : RecyclerView.ViewHolder(itemView){
        val studentprofile : ImageView = itemView.findViewById(R.id.studentprofile)
        val studentname : TextView = itemView.findViewById<MaterialTextView>(R.id.Studentname)
        val studentage : TextView = itemView.findViewById<MaterialTextView>(R.id.StudentAge)
        val studentdepart : TextView = itemView.findViewById<MaterialTextView>(R.id.StudentDepart)
        val studentse : ImageView = itemView.findViewById(R.id.studentedit)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardviewdata {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardviewresource,parent,false)
        return cardviewdata(view)
    }
    override fun getItemCount(): Int {
        return carddetailsdata.size
    }
    override fun onBindViewHolder(holder: cardviewdata, position: Int) {
        val model = carddetailsdata[position]
        holder.studentprofile.setImageResource(model.imgview)
        holder.studentname.text = model.name
        holder.studentage.text = model.age.toString()
        holder.studentdepart.text = model.department
//        holder.studentse.setImageResource(model.setting)
    }
}





