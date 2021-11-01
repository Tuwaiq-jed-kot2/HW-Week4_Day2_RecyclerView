package com.shady.hw_week04_day01_recyclerviewiml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView)
        if (currentFragment == null){
            val fragment =QuotesList()

            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainerView,fragment).commit()
        }

    }
}