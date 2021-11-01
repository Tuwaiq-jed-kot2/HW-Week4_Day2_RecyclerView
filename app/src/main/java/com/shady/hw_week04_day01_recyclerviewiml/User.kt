package com.shady.hw_week04_day01_recyclerviewiml

import androidx.annotation.StringRes
import java.util.*

data class User(val id : UUID = UUID.randomUUID(),
                var user: String = "",
                var date: Date = Date(),
                var onlineState: Boolean = false)