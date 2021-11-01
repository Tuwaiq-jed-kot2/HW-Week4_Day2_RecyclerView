package com.shady.hw_week04_day01_recyclerviewiml

import java.util.*

data class Users(
    var name: String = "",
    var message: String = "",
    var id: UUID = UUID.randomUUID()
)
