package com.shady.hw_week04_day01_recyclerviewiml

import java.util.*

data class API(val id : UUID = UUID.randomUUID(),
               var api: String = "",
               var Android: String = "",
               var isSupport: Boolean = false)
