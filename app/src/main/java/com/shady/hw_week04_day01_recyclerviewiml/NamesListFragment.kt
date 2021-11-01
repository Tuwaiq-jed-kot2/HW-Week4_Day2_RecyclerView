package com.shady.hw_week04_day01_recyclerviewiml

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.jar.Attributes


class NamesListFragment : Fragment() {

    private lateinit var  nameRC : RecyclerView
    private var  adapter : NamesAdapter? = null

    private val namesListViewModel by lazy { ViewModelProvider(this).get(NamesListViewModel::class.java) }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_names_list,container,false)

        nameRC = view.findViewById(R.id.names_RC) as RecyclerView
        nameRC.layoutManager = LinearLayoutManager(context)

        updateUI()

        return view
    }

    private fun updateUI(){
        val names = namesListViewModel.names
        adapter = NamesAdapter(names)
        nameRC.adapter = adapter
    }

    private inner class NameHolder(view : View) : RecyclerView.ViewHolder(view),View.OnClickListener{
        private lateinit var names : Names

        private val nameTV : TextView = itemView.findViewById(R.id.name)
        private val numberTV : TextView = itemView.findViewById(R.id.number)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(name : Names){
            this.names = name
            nameTV.text = this.names.name
            numberTV.text = this.names.number

        }

        override fun onClick(p0: View?) {
            val intent = Intent (Intent.ACTION_DIAL)
            intent.setData(Uri.parse("tel:${numberTV.text}"))
            startActivity(intent)
        }

    }

    private inner class NamesAdapter(var names : List<Names>):RecyclerView.Adapter<NameHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameHolder {
            val view = layoutInflater.inflate(R.layout.list_item_names,parent,false)
            return NameHolder(view)
        }

        override fun onBindViewHolder(holder: NameHolder, position: Int) {
            val name = names[position]
            holder.bind(name)
        }

        override fun getItemCount(): Int = names.size

    }
}