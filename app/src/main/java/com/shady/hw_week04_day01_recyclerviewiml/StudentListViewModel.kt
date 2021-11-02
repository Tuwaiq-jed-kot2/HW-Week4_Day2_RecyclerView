package com.shady.hw_week04_day01_recyclerviewiml

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel


class StudentListViewModel : ViewModel() {
    val students = mutableListOf<Student>()

    init {
        for (i in 0 until 16) {
            val student = Student()
            student.title = "Student #$i"
            student.isPresent = i % 2 == 0
            students += student
        }
    }
}