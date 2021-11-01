package com.example.trytoremeber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shady.hw_week04_day01_recyclerviewiml.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentFragment=supportFragmentManager
            .findFragmentById(R.id.fragment_container)
        if(currentFragment==null){
            val fragment=MemoriesListFragment()

            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container,fragment)
                .commit()
        }
    }
}