package com.shady.hw_week04_day01_recyclerviewiml

import android.util.Log
import androidx.lifecycle.ViewModel


class MovieListViewModel :ViewModel() {

    val movies = mutableListOf<Movie>()

    init {

        val movie1 = Movie("No Time to Die", "Action & Adventure", "2021")
        val movie8 = Movie("Beauty and the beast", "Animation", "1991")
        val movie3 = Movie("RON'S GONE WRONG", "Animation", "2021")
        val movie4 = Movie("VENOM", "Action & Adventure", "2021")
        val movie5 = Movie("Minamata", "Drama", "2021")
        val movie6 = Movie("ANTLERS", "Horror", "2021")
        val movie7 = Movie("UP", "Animation", "2000")
        val movie2 = Movie("The Good Father", "Drama", "1972")
        val movie9 = Movie("MONSTER FAMILY 2", "Animation", "2021")
        val movie10 = Movie("Dune", "Action & Adventure", "2021")


        movies.add(movie1)
        movies.add(movie2)
        movies.add(movie3)
        movies.add(movie4)
        movies.add(movie5)
        movies.add(movie6)
        movies.add(movie7)
        movies.add(movie8)
        movies.add(movie9)
        movies.add(movie10)


        movies.forEach { print(it) }

        Log.d("somyah", movies.toString())
    }

}
