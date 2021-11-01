package com.shady.hw_week04_day01_recyclerviewiml

import android.util.Log
import androidx.lifecycle.ViewModel

class NemeViewModel : ViewModel () {

    init{


    var names = mutableListOf("براهيم حمد عبدالعزيز"," سعد بن سعيد" ,"ابراهيم خالد بن عطيه", "الحر خالد", "سعد ابراهيم عبدالعزيز" , "ابراهيم السكاكر"," سعيد ظاف"," غالب سماح المطربي ","ابراهيم بن ابراهيم"," الحوشاب خالد"," فرحان بن هديبان" ,"الرشيد ابراهيم" ,  "محمد عبدالوهاب" ,"العر خالد" ,"محمد عبده" ,"ابراهيم محمد"," نارص العطوي"," راشد صالح"," سالمه العطوي", "احمد خالد"," احمد يل احمد" ,"خلوفه ع رافت" ,"عبدهللا حكيم", "مهرع احمد" ," احمد راكان", "قاسم مبارك الفهيق" , "شويمان بن ابراهيم" ," احمد السهي"," بن سليمان صفطه")
     val name = NameAndNUm()
names.add(name.toString())
    Log.d("bbb", names.toString())

    }

}