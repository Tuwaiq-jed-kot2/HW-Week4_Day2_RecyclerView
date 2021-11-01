package com.shady.hw_week04_day01_recyclerviewiml

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.jar.Attributes

class listFragment : Fragment() {
    private lateinit var nameAndNUmRecycleView: RecyclerView
    val crimeListViewModel by lazy { ViewModelProvider(this).get(NemeViewModel::class.java) }

        override fun onCreateView(  // مهمه ربطت االكلاس  فراقمنت بالاكس تبعه ام اكس ,  اول خطوة
            inflater: LayoutInflater,
            container: ViewGroup?, //   راح نمرر الكونتينر  تحت
            savedInstanceState: Bundle?
        ): View? {

             val view = inflater.inflate(R.layout.fragment_list, container, false)
            nameAndNUmRecycleView = view.findViewById(R.id.recycleView)
            val linearLayoutManager = LinearLayoutManager(context)
            nameAndNUmRecycleView.layoutManager = linearLayoutManager

           updetAdapt()

            return view

        }

        private fun updetAdapt() {
            val nameAdapter = NameAdapter(NemeViewModel.name)
            nameAndNUmRecycleView.adapter = nameAdapter  // ابغا الادابتر يساوي الابدتر
        }

        private inner class NameeHolder(view: View) : RecyclerView.ViewHolder(view),

View.OnClickListener{

            private val nameTextView: TextView = itemView.findViewById(R.id.name_view)
            private val naumberTextView: TextView = itemView.findViewById(R.id.num_view)




        init {
            nameTextView.setOnClickListener(this) // : implement :On Click  ال>س هي الوراثه الي فوق جنب الكلاس
            naumberTextView.setOnClickListener(this)

        }
        fun bind(name: NameAndNUm) {
            this.name = name // اقصد الفار من الكلاس
            nameTextView.text = name.name
            nameTextView.text = name.number.toString()

            override fun onClick(v: View?) {
                if (v == nameTextView) {
                    Toast.makeText(context, "your name", Toast.LENGTH_LONG).show()
                } else if (v == nameTextView) {
                    Toast.makeText(context, "your number", Toast.LENGTH_LONG).show()
                }
            }
        }}
            private inner class NameAdapter(var nameAndNUm: List<name>) :
                RecyclerView.Adapter<NameeHolder>() {
                override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameeHolder {
                    val view = layoutInflater.inflate(R.layout.fragment_list, parent, false)
                    return NameeHolder(view) // ربطنا ملف الاكس ام ل بالفهولدر عن طريق الادابتر لانه المسئول
                }

                override fun onBindViewHolder(holder: NameeHolder, position: Int) {

                    val name = nameAndNUm[position]
                    holder.bind(name)
                }

                override fun getItemCount(): Int = nameAndNUm.size


            }
        }
    }



