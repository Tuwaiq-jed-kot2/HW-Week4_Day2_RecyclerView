package com.shady.hw_week04_day01_recyclerviewiml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentFragment= supportFragmentManager
        supportFragmentManager.findFragmentById(R.id.My_Recycler_View)

        if (currentFragment==null) {


            val fragment2 = RowListFragment()

            supportFragmentManager
                .beginTransaction()

                .add(R.id.My_Recycler_View, fragment2)
                .commit()





    }
}