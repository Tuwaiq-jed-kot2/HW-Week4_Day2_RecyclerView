package com.example.trytoremeber

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shady.hw_week04_day01_recyclerviewiml.R
import java.util.logging.MemoryHandler


class MemoriesListFragment : Fragment() {

    lateinit var MemoriesRecycleView : RecyclerView



val MemoriesListViewModel by lazy { ViewModelProvider(this).get(MemoriesListViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       val view = inflater.inflate(R.layout.fragment_memories_list, container, false)
        MemoriesRecycleView=view.findViewById(R.id.memories_recycle_view)
        val linearLayoutManager= LinearLayoutManager(context)
        MemoriesRecycleView.layoutManager=linearLayoutManager
        val memoriesAdapter=MemoriesAdapter(MemoriesListViewModel.memories)
        MemoriesRecycleView.adapter=memoriesAdapter

        updateUI()
        return view
    }

    fun updateUI(){
        val memoriesAdapter= MemoriesAdapter(MemoriesListViewModel.memories)
        MemoriesRecycleView.adapter=memoriesAdapter
    }





    private inner class MemoriesHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener{
        private lateinit var memories: Memories
        private val titleTextView:TextView=itemView.findViewById(R.id.memory_item_title)
        private val detailsTextView:TextView=itemView.findViewById(R.id.memory_item_details)
        private val happyImageView:ImageView=itemView.findViewById(R.id.happy_face_iv)


        init {
            titleTextView.setOnClickListener(this)
            detailsTextView.setOnClickListener(this)


        }

        fun bind(memories: Memories){
            this.memories=memories
            titleTextView.text=memories.title
            detailsTextView.text=memories.details



        }

        override fun onClick(happy : View?) {

            if (happy==titleTextView){
                Toast.makeText(context,"the title is ${memories.title}",Toast.LENGTH_LONG).show()

        }else if (happy==detailsTextView){
            Toast.makeText(context,"the details is ${memories.details}",Toast.LENGTH_LONG).show()
            }

            }


    }

    private inner class MemoriesAdapter(val memories:List<Memories>):RecyclerView.Adapter<MemoriesHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoriesHolder {
            val view = layoutInflater.inflate(R.layout.list_item_memories,parent,false)

            return MemoriesHolder(view)
        }

        override fun onBindViewHolder(holder: MemoriesHolder, position: Int) {
            val memory=memories[position]

            holder.bind(memory)

        }

        override fun getItemCount(): Int {
            return memories.size

        }

    }


}