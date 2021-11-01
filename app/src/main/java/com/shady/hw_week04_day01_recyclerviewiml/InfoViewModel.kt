package com.shady.hw_week04_day01_recyclerviewiml

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class InfoViewModel :ViewModel(){

    val infos= mutableListOf<Info>()




init {

    for (i in 0..14){
        val info=Info()
        info.name="the number of name is $i"
        infos.add(info)

    }

}
}