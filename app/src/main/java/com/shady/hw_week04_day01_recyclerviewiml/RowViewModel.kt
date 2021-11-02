package com.shady.hw_week04_day01_recyclerviewiml

import androidx.lifecycle.ViewModel

class RowViewModel:ViewModel (){

    val row1 = mutableListOf<Row>()
    init {
        for (B in 0..16){
            val Row = Row ()

            Row.names="Bayan $B"
            Row.reminder="YOU CAN DO IT $B"

            row1.add(Row)


        }
    }
}



