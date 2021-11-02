package com.example.shahad

import androidx.lifecycle.ViewModel

class TopListViewModel:ViewModel() {

    val name = mutableListOf<Names>()

    init {
        for (i in 0..16) {

            val names = Names()
            names.tops = "top student $i"
            names.name = "the name of student $i"

        }

    }
}