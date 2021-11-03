package com.shady.hw_week04_day01_recyclerviewiml

import androidx.lifecycle.ViewModel

class ColorViewM :ViewModel() {
    val colors = mutableListOf<Color>()
        val colorsName = listOf(
            "red","blue","black","yellow","orange","ghh","fff","fdss","ffffd","tttt","aaaa","tgt","gds"
            ,"fffj","wwwww","rrrrre"
        )
        init {
            for (i in 0 until 15) {
                val color = Color()
                color.title = "crime number $i"
                color.isDone = i % 2 == 0
                colors += color
            }
        }
}