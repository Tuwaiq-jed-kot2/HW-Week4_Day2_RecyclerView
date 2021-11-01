package com.shady.hw_week04_day01_recyclerviewiml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val currentFragment= supportFragmentManager.findFragmentById(R.id.fragment_container)//create fragment
        if (currentFragment == null){
            val fragment=ListOfFragment()
            //  val fragment=CrimeListFragment()
            supportFragmentManager
                .beginTransaction()//we have fragment come beReady 2
                .add(R.id.fragment_container,fragment)
                .commit()
    }
}}