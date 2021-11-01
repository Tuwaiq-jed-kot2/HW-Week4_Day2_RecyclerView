package com.shady.hw_week04_day01_recyclerviewiml

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class GPUFragment : Fragment() {

    private lateinit var gpuNameTv: TextView
    private lateinit var gpuReleaseDateTv : TextView

    private lateinit var gpu : GPUs

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_gpu,container,false)

        gpuNameTv = view.findViewById(R.id.gpu_name)
        gpuReleaseDateTv = view.findViewById(R.id.gpu_release_date)

        return view
    }

   
}