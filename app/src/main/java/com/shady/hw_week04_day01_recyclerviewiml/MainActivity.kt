package com.shady.hw_week04_day01_recyclerviewiml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val currentFragment=supportFragmentManager.findFragmentById(
            R.id.fragmentC)
        if (currentFragment!=null){
            val fragment=Fragment_lisys()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentC,fragment)
                .commit()
        }
    }
}