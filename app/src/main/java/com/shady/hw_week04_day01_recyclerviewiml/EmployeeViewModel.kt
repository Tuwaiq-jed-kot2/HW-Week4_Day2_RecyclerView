package com.shady.hw_week04_day01_recyclerviewiml
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class EmployeeViewModel:ViewModel() {
    var employee= mutableListOf<EmpData>()

    fun getRandomString(length: Int) : String {
        val allowedChars = ('A'..'Z') + ('a'..'z')
        return (1..length)
            .map { allowedChars.random() }
            .joinToString("")
    }
    init {
        for (i in 1..20){
            val emp=EmpData()

            emp.randomName=getRandomString(6)
            emp.roomNum= Random.nextInt(40)+10
            emp.atWork= emp.roomNum % 2!=0
            employee.add(emp)
        }

    }

}