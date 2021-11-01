package com.shady.hw_week04_day01_recyclerviewiml

import androidx.lifecycle.ViewModel
import java.util.*

class StoryListViewModel : ViewModel() {

    val stories = mutableListOf<Story>()

    init {
             for (i in 0 until 15){
                 val story = Story()
                 story.title = "story number $i"
                 story.isRead = i % 2 == 0

                 stories += story

             }
    }


}