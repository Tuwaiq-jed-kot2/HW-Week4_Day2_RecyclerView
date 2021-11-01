package com.shady.hw_week04_day01_recyclerviewiml

import androidx.lifecycle.ViewModel
import kotlin.random.Random.Default.nextInt

class CoffeeListViewModel: ViewModel() {

    var coffeeDrinks = mutableListOf<Coffee>()

    init {
        for (i in 0..15) {
            val coffee = Coffee()
            coffee.name = "Coffee No. $i"
            coffee.price = nextInt(15, 30)
            coffeeDrinks.add(coffee)
        }
    }
}