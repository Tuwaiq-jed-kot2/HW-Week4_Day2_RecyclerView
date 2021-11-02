package com.shady.hw_week04_day01_recyclerviewiml

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RycAdapter(private val cList: List<Contact>) : RecyclerView.Adapter<RycAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = cList[position]

        holder.imageView.setImageResource(ItemsViewModel.image)
        holder.NameView.setText(ItemsViewModel.name)
        holder.PhoneView.setText(ItemsViewModel.phonNum.toString())

    }

    override fun getItemCount(): Int {
        return cList.size
    }

    // Holds the views for adding it to image and text
    inner class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val NameView: TextView = itemView.findViewById(R.id.contact_Name)
        val PhoneView: TextView = itemView.findViewById(R.id.contact_num)

    }
}
