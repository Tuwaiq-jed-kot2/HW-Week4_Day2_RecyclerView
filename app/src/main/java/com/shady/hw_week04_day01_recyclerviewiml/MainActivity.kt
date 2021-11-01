package com.shady.hw_week04_day01_recyclerviewiml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentFragment =supportFragmentManager.findFragmentById(R.id.fragmentContainerView)
        if (currentFragment==null){
            val fraqment =listFragment ()  //اوجكت من الفراقمنت , ثاني خطوة //
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainerView,fraqment) //  + اوبجكت الفراق+
                // id ااي راح اخزن فيه معلومات الفراق  الي في ملف الاكتفتي اكس ام
                .commit()
        }
    }
}