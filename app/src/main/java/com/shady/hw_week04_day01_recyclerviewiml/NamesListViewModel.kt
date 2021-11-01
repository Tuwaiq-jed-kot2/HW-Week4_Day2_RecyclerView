package com.shady.hw_week04_day01_recyclerviewiml

import androidx.lifecycle.ViewModel

class NamesListViewModel : ViewModel(){

    val names = mutableListOf<Names>()

    init {

        for (x in 1..15){
            val name = Names()
            name.name="Person $x"
            name.number="0501234$x"
            names.add(name)
        }

    }




}