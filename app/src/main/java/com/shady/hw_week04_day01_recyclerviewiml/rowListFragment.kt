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


class RowListFragment : Fragment() {


    private lateinit var rowRecyclerView: RecyclerView

    val rowViewModel by lazy { ViewModelProvider(this)
        .get(RowViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_row_list, container, false)
        rowRecyclerView=view.findViewById(R.id.My_Recycler_View)

        val linearLayoutManager = LinearLayoutManager(context)
       rowRecyclerView.layoutManager = linearLayoutManager

        return view


    }


    }



private inner class CrimeViewHolder(view: View) : RecyclerView.ViewHolder(view),View.OnClickListener {
// الين هنا خلاص انا سويت الفيو هولدر

    // من هنا الين تحت سوينا اللي موجود في xml
    private lateinit var row: Row

    private val nameTextViw: TextView = itemView.findViewById(R.id.name_tex)
    private val reminderTextView: TextView = itemView.findViewById(R.id.reminder_tex)

    init {

        nameTextViw.setOnClickListener(this)
        reminderTextView.setOnClickListener(this)
    }

    fun bing (row: Row) {
        this.row = Row
        nameTextViw.text = row.names
        reminderTextView.text = row.reminder


    }

    override fun onClick(p0: View?) {
        if (p0==nameTextViw){
            Toast.makeText(context,"the name is ${nameTextViw}", Toast.LENGTH_LONG).show()
        }else if(p0==reminderTextView){
            Toast.makeText(context,"the reminder  is ${reminderTextView}", Toast.LENGTH_SHORT).show()
        }
        // adapter هو المسول عن عملية الربط
        private inner class ROW (var row: List<Row>) :
            RecyclerView.Adapter<RowHolder>() {

        }
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): rowViewHolder {
                val view =LayoutInflater.inflate(R.layout.fragment_row_list, parent, false)
                return CrimeViewHolder(view)

            }


        // احدد حاليا في اي اندكس [position]
        override fun onBindViewHolder(holder: CrimeViewHolder, position: Int) {
            val crime = row [position]}
            holder.bing(row)
        }


    override fun getItemCount(): Int = row.size





