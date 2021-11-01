package com.shady.hw_week04_day01_recyclerviewiml

import android.os.Parcel
import android.os.Parcelable
import java.util.*


data class NameAndNUm
    (val id:UUID=UUID.randomUUID(),

     var name : String = "",
     var number: Int
)


