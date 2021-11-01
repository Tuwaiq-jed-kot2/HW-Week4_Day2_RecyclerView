package com.shady.hw_week04_day01_recyclerviewiml

import androidx.lifecycle.ViewModel

class ChatListViewModel: ViewModel() {
    val chat = mutableListOf<User>()
    val names = listOf(
        "Shuruq",
        "Ashwag",
        "Amal",
        "Mohammed",
        "Eyad",
        "Hind",
        "Anas",
        "Asma",
        "Ahmed",
        "Reem",
        "Rahaf",
        "Rawan",
        "Zienab",
        "Manar",
        "Hajar"
    )
    init {
        for (i in 0 until 15){
            val user = User()
            user.user = names[i]
            user.onlineState = i %2 == 0
            chat += user
        }
    }




}