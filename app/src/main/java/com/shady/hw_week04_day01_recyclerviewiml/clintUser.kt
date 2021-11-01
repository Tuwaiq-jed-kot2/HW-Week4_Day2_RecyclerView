package com.shady.hw_week04_day01_recyclerviewiml

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class clintUser : Fragment() {
    private lateinit var clintRV:RecyclerView
    private val clintUserView by lazy { ViewModelProvider(this).get(ClintView::class.java)}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_clint_user, container, false)
        val linearLM= LinearLayoutManager(context)
        clintRV.layoutManager=linearLM

        val clintAdabter=ClintView(ClintView.clints)



        return view

    }

    override inner class ClintVH(view: View): RecyclerView.ViewHolder(view),View.OnClickListener{
    private lateinit var clint:ClintView
    val userClintTV:TextView=itemView.findViewById(R.id.user_Name)
        val emailClintTV:TextView=itemView.findViewById(R.id.user_email)
        val imageVI: View? =itemView.findViewById(R.id.imageVM_item)

        init {
            userClintTV.setOnClickListener(this)
            emailClintTV.setOnClickListener(this)
        }
        fun bind(clint: ClintView){ //set text send the data from onBindViewHolder
            this.clint=clint
            userClintTV.text=clint.userName
            emailClintTV.text=clint.useremil
            imageVI.


        }
        override fun onClick(v: View?) {
            Toast.makeText(context,"the user name is ${},the user emil is ${clint.clints}",Toast.LENGTH_SHORT).show()
        }



    private  inner class ClintAdabter(var clints:MutableList<ClintView>):RecyclerView.Adapter<ClintVH>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClintVH {
            val view=layoutInflater.inflate(R.layout.clint_user,parent,false)
            return ClintVH(view)
        }
        override fun onBindViewHolder(holder: ClintVH, position: Int) {
            val clint=clints[position]
            holder.bind(clint)

        }
        override fun getItemCount(): Int = clints.size


        }


    }


}