package com.shady.hw_week04_day01_recyclerviewiml

import androidx.lifecycle.ViewModel

class List_viewModle:ViewModel() {
    var lists= mutableListOf<List1>()
     val letter= listOf(
        "A","B","C","D","J","U","O","P","Q","M","A","X","V","S","B","R"
    )
    init {
        for (i in 0 until  15){
            val list=List1()
            list.title="the numbers $i"
            list.isDone=i % 2==0
            lists+=list
        }
    }
}