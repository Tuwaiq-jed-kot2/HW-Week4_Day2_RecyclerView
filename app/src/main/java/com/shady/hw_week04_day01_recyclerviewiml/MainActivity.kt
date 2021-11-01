package com.example.criminalintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shady.hw_week04_day01_recyclerviewiml.R
import com.shady.hw_week04_day01_recyclerviewiml.fragment_crime_list

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val currentFragment =supportFragmentManager.findFragmentById(R.id.fragmentContainerView2)
        //لان كل الفرلقمانت تتخزن في الكونتينر
        if(currentFragment!=null){

            //هذا يرجغ للصفحه الثالنيه
            val fragment=fragment_crime_list()//عمليه الربط مع الفراقمنت
            //object
            supportFragmentManager.
            beginTransaction()
                .replace(R.id.fragmentContainerView2,fragment)
//                .replace(R.id.fragment_container.ff)
                //فراقمنت ترجع للصفحه اللي قبل

                .commit()
            //كومنتت يعني ابدا

        }
    }
}

