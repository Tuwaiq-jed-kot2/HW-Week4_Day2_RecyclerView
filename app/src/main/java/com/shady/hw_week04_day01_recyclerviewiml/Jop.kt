package com.example.criminalintent

import android.icu.text.CaseMap
import android.icu.text.DateFormat
import java.time.DateTimeException
import java.util.*

data class Jop(
    val id:UUID= UUID.randomUUID(),
    var title: String="",
    var date: Date = Date(),
    var istaken:Boolean=false
)