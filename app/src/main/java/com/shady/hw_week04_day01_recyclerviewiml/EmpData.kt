package com.shady.hw_week04_day01_recyclerviewiml

import java.time.LocalDate
import java.time.Month
import java.util.*



data class EmpData(
    var randomName: String = UUID.randomUUID().toString(),
    var atWork: Boolean = false,
    var roomNum:Int=0,
    var date: LocalDate = LocalDate.now()

)
