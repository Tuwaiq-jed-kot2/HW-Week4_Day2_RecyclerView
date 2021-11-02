package com.shady.hw_week04_day01_recyclerviewiml

import androidx.lifecycle.ViewModel

class ApiListViewModel : ViewModel() {

    val APIs = mutableListOf<API>()

    init {
        for (i in 0 until 20){
            val API = API()
            API.api = "API version = $i"
            API.Android = "Android API LEVEL"
            API.isSupport = i % 2 == 0
            APIs += API
        }
    }
}