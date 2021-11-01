package com.shady.hw_week04_day01_recyclerviewiml

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NamesFragmentList:Fragment() {
    private lateinit var namerecyclerview :RecyclerView

    val nameViewModel by lazy { ViewModelProvider(this).
    get(NameViewModel::class.java)}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.frament_name_list,container,false)
        namerecyclerview=view.findViewById(R.id.name_Recycler_VIew)
       val linearLayoutManager=LinearLayoutManager(context)
        namerecyclerview.layoutManager=linearLayoutManager
        //ADUPEATER
        val nameAdapter=NameAdapter(nameViewModel.nameas)
        namerecyclerview.adapter=nameAdapter
        return view
    }
    private inner class NameHolder(view: View)
        : RecyclerView.ViewHolder(view),View.OnClickListener {
        private lateinit var nameA:Namedate
        val nameTextView: TextView =itemView.findViewById(R.id.name_title1)
        val numberTextView: TextView =itemView.findViewById(R.id.number_titlle2)
        val isSolvedImageView: ImageView =itemView.findViewById(R.id.image_name_num)
        init {
            nameTextView.setOnClickListener(this)
            numberTextView.setOnClickListener(this)
            isSolvedImageView.setOnClickListener(this)

        }
        fun bing(name:Namedate){
          this.nameA=name
                  nameTextView.text=name.namess
                 numberTextView.text=name.numberss
    }
        override fun onClick(v: View?) {
            if (v==nameTextView){
                Toast.makeText(context,"the name is${nameA.namess}",Toast.LENGTH_LONG).show()
            }else if (v==numberTextView)
                Toast.makeText(context,"the number is${nameA.numberss}",Toast.LENGTH_LONG).show()
        }

    }
    private inner class NameAdapter(var names:List<Namedate>):
        RecyclerView.Adapter<NameHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameHolder {
            val view=layoutInflater.inflate(R.layout.fragment_name,parent,false)
            return NameHolder(view)
        }

        override fun onBindViewHolder(holder: NameHolder, position: Int) {
            val name=names[position]
            holder.bing(name)
        }

        override fun getItemCount(): Int =names.size
    }



}