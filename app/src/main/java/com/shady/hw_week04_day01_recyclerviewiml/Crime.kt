package com.example.criminalintent

import java.util.*


//    لداتاىكلاس لازم يكون لها عالاقل واحد براميتير
data class Crime( val id:UUID=UUID.randomUUID(),
                  var title :String="",
                  var date : Date = Date(),
                  var isSolved:Boolean=false,

                  )
