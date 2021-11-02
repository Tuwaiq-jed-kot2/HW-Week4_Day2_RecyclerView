package com.example.criminalintent

import android.util.Log
import androidx.lifecycle.ViewModel

class JopListViewModel:ViewModel() {

    val jops= mutableListOf<Jop>()

    init {
        for (i in 1 until  101){
            val jop = Jop()
            jop.title = "Jop Announcement $i"
            jop.istaken= i%2==0
            jops+=jop
        }
        // Log.d("anas",crimes.toString())
    }


}