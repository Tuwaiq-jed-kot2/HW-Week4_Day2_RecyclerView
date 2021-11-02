package com.shady.hw_week04_day01_recyclerviewiml

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


class API_Fragment : Fragment() {

    private lateinit var API_RecyclerView: RecyclerView
    private lateinit var isSupport_image: RecyclerView

    private val apiListViewModel: ApiListViewModel by lazy { ViewModelProvider(this).get(ApiListViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_a_p_i_list_, container, false)
        API_RecyclerView = view.findViewById(R.id.API_recycle_View)
        val linearLayoutManager = LinearLayoutManager(context)
        API_RecyclerView.layoutManager = linearLayoutManager
        updateUI()
        return view
    }
    private inner class ApiViewHolder(view:View)
        :RecyclerView.ViewHolder(view) , View.OnClickListener{

            private lateinit var api:API

            private val API_text_View:TextView = itemView.findViewById(R.id.Api_item)
            private val android_text_View:TextView = itemView.findViewById(R.id.Android_item)
            private val isSupport_image:ImageView = itemView.findViewById(R.id.isSupport_image)

        init {
            API_text_View.setOnClickListener(this)
            android_text_View.setOnClickListener(this)
        }

        fun bind(api: API){
            this.api = api
            API_text_View.text = api.api
            android_text_View.text = api.Android
            isSupport_image.visibility = if (api.isSupport){
                View.VISIBLE
            }else{
                View.GONE
            }
        }

        override fun onClick(v: View?) {
            if (v == API_text_View){
                Toast.makeText(context , "the api is ${api.api}" , Toast.LENGTH_LONG).show()
            }else if (v == android_text_View){
                Toast.makeText(context , "The Android:${api.api}" , Toast.LENGTH_LONG).show()
            }
        }

    }

    private fun updateUI(){
        val apiAdapter = APiAdapter(apiListViewModel.APIs)
        API_RecyclerView.adapter = apiAdapter
    }

    private inner class APiAdapter(var APIs:List<API>)
        : RecyclerView.Adapter<ApiViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApiViewHolder {
            val view = layoutInflater.inflate(R.layout.list_item_api , parent , false)
            return ApiViewHolder(view)
        }

        override fun onBindViewHolder(holder: ApiViewHolder, position: Int) {
            val api = APIs[position]
            holder.bind(api)
        }

        override fun getItemCount(): Int = APIs.size
        }

    }