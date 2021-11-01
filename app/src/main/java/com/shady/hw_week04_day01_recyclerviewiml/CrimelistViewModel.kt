package com.example.criminalintent

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel

class CrimelistViewModel :ViewModel() {
    val crimes= mutableListOf<Crime>()
    init {
        for (i in 0..100){
            val crime=Crime()
            crime.title="crime number $i"
            crime.isSolved= i%2==0
            crimes+=crime
        }
        Log.d("SARA",crimes.toString())
    }
//نفس ااكود هذا اقدر استخدمه فالافراقمنت
}
