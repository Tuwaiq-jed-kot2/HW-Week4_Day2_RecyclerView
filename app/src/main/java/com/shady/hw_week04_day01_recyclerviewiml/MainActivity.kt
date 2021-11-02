package com.example.movielist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.shady.hw_week04_day01_recyclerviewiml.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_Container)

        if (currentFragment == null) {
            val fragment = MovieListFragment()

            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_Container, fragment)
                .commit()
        }

    }
}