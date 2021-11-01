package com.example.trytoremeber

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel

class MemoriesListViewModel: ViewModel() {

    val memories= mutableListOf<Memories>()

    init {
        for ( m in 1..20) {
            val memories1 = Memories()
            memories1.title = "memory $m"
            memories1.details="Check This Happy Moment!!"
            memories+=memories1



        }
    }






}