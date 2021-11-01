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

class GpuListFragment : Fragment() {

    private lateinit var gpuListRc : RecyclerView

    private val gpuViewModel by lazy { ViewModelProvider(this).get(GPUsViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list_gpu,container,false)

        gpuListRc = view.findViewById(R.id.gpu_list)

        val linearLayoutManager = LinearLayoutManager(context)
        gpuListRc.layoutManager = linearLayoutManager

        updateUI()

        return view
    }

    private fun updateUI(){
        val gpuAdapter = GPUAdapter(gpuViewModel.gpu)

        gpuListRc.adapter = gpuAdapter
    }

    private inner class GPUHolder (view : View): RecyclerView.ViewHolder(view) , View.OnClickListener{

       private val gpuName :TextView = itemView.findViewById(R.id.gpu_name)
       private val gpuReleaseDate :TextView = itemView.findViewById(R.id.gpu_release_date)
       private val rtx :ImageView = itemView.findViewById(R.id.RTX)


        private lateinit var gpu : GPUs

        init {
            gpuName.setOnClickListener(this)
            gpuReleaseDate.setOnClickListener(this)
        }

        fun bind (GPU:GPUs){
            this.gpu = GPU

            gpuName.text = GPU.name
            gpuReleaseDate.text = GPU.releaseDate
            rtx.visibility = if (GPU.RTX){
                View.VISIBLE
            }else{
                View.GONE
            }
        }

        override fun onClick(v: View?) {
            if (v == gpuName){
                Toast.makeText(context,"this GPU name is ${gpu.name}",Toast.LENGTH_LONG).show()
            }else if (v == gpuReleaseDate){
                Toast.makeText(context,"this GPU was released on ${gpu.releaseDate}",Toast.LENGTH_LONG).show()
            }
        }

    }

    private inner class GPUAdapter (var GPUs:List<GPUs>) : RecyclerView.Adapter<GPUHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GPUHolder {

            val view = layoutInflater.inflate(R.layout.fragment_gpu,parent,false)

            return GPUHolder(view)
        }

        override fun onBindViewHolder(holder: GPUHolder, position: Int) {
            val GPU = GPUs[position]

            holder.bind(GPU)
        }

        override fun getItemCount(): Int = GPUs.size

    }


    
}