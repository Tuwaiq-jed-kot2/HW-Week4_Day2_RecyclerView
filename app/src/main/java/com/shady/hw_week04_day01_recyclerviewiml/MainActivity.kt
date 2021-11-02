package com.example.jforjop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentFragment=
            supportFragmentManager.findFragmentById(R.id.fragment_containers)

        if (currentFragment==null){
            val fragment=JopListFragment()
            supportFragmentManager.beginTransaction().add(R.id.fragment_containers,fragment)
                .commit()
        }
    }
}