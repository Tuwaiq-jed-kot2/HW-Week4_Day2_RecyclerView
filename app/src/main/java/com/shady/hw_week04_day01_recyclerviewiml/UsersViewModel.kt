package com.shady.hw_week04_day01_recyclerviewiml

import androidx.lifecycle.ViewModel

class UsersViewModel : ViewModel() {

    val users = mutableListOf<Users>()

    init {
        for (i in 0..15){
            var user = Users()
            user.name = "User ${i+1}"
            user.message = "Some Message"
            users += user
        }
    }
}