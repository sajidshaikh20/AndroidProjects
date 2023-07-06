package com.example.androidprojects.task.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidprojects.R
import com.example.androidprojects.recyclerview.adapter.cardadapter
import com.example.androidprojects.task.model.UserModel
import com.example.androidprojects.task.model.interfaceClass.DetailsInterface
import com.google.android.material.card.MaterialCardView

class UserCardAdapter(
    val requireContex: Context, val data: ArrayList<UserModel>,
    val detailsInterface: DetailsInterface

) : RecyclerView.Adapter<UserCardAdapter.UserCardViewHolder>() {


    class UserCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.edtUserName)
        val email = itemView.findViewById<TextView>(R.id.edtUserMail)
        val number = itemView.findViewById<TextView>(R.id.edtUserNumber)



        //card view id
        val cardView = itemView.findViewById<MaterialCardView>(R.id.cvUserData)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserCardViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.user_data_card, parent, false)
        return UserCardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: UserCardViewHolder, position: Int) {
        val model = data[position]
        holder.name.text = model.name
        holder.number.text = model.number
        holder.email.text = model.Email


        holder.cardView.setOnClickListener {

            Log.i("genderhere", model.male+" "+model.female)
            Log.i("hobies", model.chess+" "+model.cook+" "+model.travel+" "+model.dance)
      detailsInterface.getDetails(model.name.toString(),model.Email.toString(),model.number.toString(),model.Dob.toString(),model.male.toString(),model.female.toString(),model.chess.toString(),model.cook.toString(),model.travel.toString(),model.dance.toString())
         }
    }
}
