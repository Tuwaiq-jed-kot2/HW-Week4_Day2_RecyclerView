package com.shady.hw_week04_day01_recyclerviewiml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private lateinit var contReyclerView: RecyclerView

class MainActivity : AppCompatActivity() {

    val contacts = mutableListOf<Contact>()





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val contactList = mutableListOf<Contact>()
        for (i in 0 until 15){
            val contact =Contact()
            contact.name = "Eman $i"
            contact.phonNum = 1234567891
            contactList.add(contact)
        }


        contReyclerView = findViewById(R.id.recyclerViewId)

        val linearLayoutManger = LinearLayoutManager(this)
        contReyclerView.layoutManager = linearLayoutManger

        val adapter = RycAdapter(contactList)
        contReyclerView.adapter = adapter







    }












}