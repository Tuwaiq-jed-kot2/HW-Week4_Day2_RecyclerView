package com.shady.hw_week04_day01_recyclerviewiml

import androidx.lifecycle.ViewModel



class BookListViewModel: ViewModel() {

    val books = mutableListOf<Book>()

    val bookname= listOf(
        "The Raven",
        "The Terrifying Tales",
        "The Fall of the House of Usher",
        "The Cask of Amontillado ",
        "The Murders in the Rue Morgue",
        "The Masque Of The Red Death",
        "The Gold-Bug",
        "The Pit And The Pendulum",
        "Tales of Mystery and Imagination",
        "Classic Tales of Horror",
        "The Murders in the Rue Morgue",
        "Tales of Death and Dementia",
        "The Black Cat",
        "The Science Fiction of Edgar Allan Poe",
        "Nevermore")

    init {
        for (i in 0..14 ) {
            val book=Book()
            book.title= bookname[i].uppercase()
            book.name="The author is Edgar Allan Poe".uppercase()
            books+=book        }

    }
}
