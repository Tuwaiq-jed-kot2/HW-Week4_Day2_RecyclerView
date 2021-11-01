package com.shady.hw_week04_day01_recyclerviewiml

import androidx.lifecycle.ViewModel

class NameViewModel:ViewModel() {
    val nameas= mutableListOf<Namedate>()
    init {
        for (i in 0..16) {
            val name = Namedate()
            name.namess = "Rouya...........$i"
            name.numberss= "Number ....................$i"
            nameas+=name
        }
    }
}