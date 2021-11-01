package com.shady.hw_week04_day01_recyclerviewiml

import java.util.*

data class List1(
    val id:UUID=UUID.randomUUID(),
    var title :String="",

    var isDone:Boolean=false
)