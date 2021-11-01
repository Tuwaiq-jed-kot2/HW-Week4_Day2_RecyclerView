package com.shady.hw_week04_day01_recyclerviewiml

import androidx.lifecycle.ViewModel

  class ClintView:ViewModel() {
      val clints = mutableListOf<Clint>()

      init {

          for (i in 0..99) {
              val clint = Clint()
              clint.userName = "rwan"
              clint.useremil = "rrrr@hhhh"
              clints += clint

          }

      }
  }



