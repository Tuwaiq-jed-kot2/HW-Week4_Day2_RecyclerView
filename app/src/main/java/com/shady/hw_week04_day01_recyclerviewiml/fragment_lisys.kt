package com.shady.hw_week04_day01_recyclerviewiml

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Fragment_lisys:Fragment() {
    private lateinit var listRecyclView: RecyclerView
    val listViewmodle by lazy {
    ViewModelProvider(this).get(List_viewModle::class.java)
            }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.second, container, false)
        listRecyclView = view.findViewById(R.id.second)
        val linearLayoutManager = LinearLayoutManager(context)
        listRecyclView.layoutManager = linearLayoutManager
        update()
        return view
    }
    private fun update() {
        val list1Apdator = ListAdaptor(listViewmodle.lists)
        listRecyclView.adapter = list1Apdator
    }
    private inner class list0ViewHolder(list1: View)
        :RecyclerView.ViewHolder(list1),View.OnClickListener{
    private  var list4=list1

         val TitltV:TextView= itemView.findViewById(R.id.textView2)
         val numT:TextView= itemView.findViewById(R.id.textView3)
         val isImage:TextView= itemView.findViewById(R.id.isImage)
        init {
         TitltV.setOnClickListener(this)
         numT.setOnClickListener (this)
        }
        fun bind (listt: List1){
            this.list4=list4
            TitltV.text=listt.title
            numT.text=listt.title
            isImage.visibility=if (listt.isDone){
             View.VISIBLE
            }else{
              View.GONE
            }

        }

        override fun onClick(v: View?) {
        Toast.makeText(context,"the title is ${list4}",Toast.LENGTH_LONG).show()

        }

    }


    private inner class ListAdaptor(var list3:List<List1>)
        :RecyclerView.Adapter<list0ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): list0ViewHolder {
            val view=layoutInflater.inflate(R.layout.activity_main,parent,false)
            return list0ViewHolder(view)
        }

        override fun onBindViewHolder(holder: list0ViewHolder, position: Int) {
            val list=list3[position]
            holder.bind(list)

        }
        override fun getItemCount(): Int = list3.size


    }

}