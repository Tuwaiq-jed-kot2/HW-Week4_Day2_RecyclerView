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

class Color_list: Fragment() {
    private lateinit var colorRecycleView: RecyclerView
    val colorListViewModel
            by lazy { ViewModelProvider(this).get(ColorViewM::class.java) }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.list_re,container,false)
     colorRecycleView=view.findViewById(R.id.listRe)
        val linearLayoutManager= LinearLayoutManager(context)
        colorRecycleView.layoutManager=linearLayoutManager
        val colorAdaptor = ColorAdaptor(colorListViewModel.colors)
        colorRecycleView.adapter = colorAdaptor

        return view

    }





    private inner class ColorViewHolder(view: View)
        : RecyclerView.ViewHolder(view), View.OnClickListener {
        private lateinit var color: Color

        private val titleTextView: TextView = itemView.findViewById(R.id.textView)
        private val dateTextView: TextView =itemView.findViewById(R.id.textView1)
        private val isSolvedImage: ImageView = itemView.findViewById(R.id.isImage)

        init {
            titleTextView.setOnClickListener(this)
            dateTextView.setOnClickListener(this)

        }

        fun bind(color: Color){

            this.color=color
            titleTextView.text=color.title
            isSolvedImage.visibility=if (color.isDone){
                View.VISIBLE
            }else{
                View.GONE
            }
        }

        override fun onClick(v: View?) {
                Toast.makeText(context,"the title is ${color.title}", Toast.LENGTH_LONG).show()
            }
    }
    private inner class ColorAdaptor(var colors: List<Color>)
        : RecyclerView.Adapter<ColorViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): ColorViewHolder {
            val view=layoutInflater.inflate(R.layout.list_re,parent,false)
            return ColorViewHolder(view)
        }

        override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
            //to select right index
            val crime=colors[position]
            holder.bind(crime)

        }
        override fun getItemCount(): Int = colors.size


    }
}
