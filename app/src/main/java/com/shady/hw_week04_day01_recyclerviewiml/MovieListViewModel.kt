package com.example.movielist

import android.util.Log
import androidx.lifecycle.ViewModel



class MovieListViewModel :ViewModel() {

    val movies = mutableListOf<Movie>()

    init {

        val movie1 = Movie("No Time to Die", "Action & Adventure", "2021" )
        val movie2 = Movie("Beauty and the beast", "Animation", "1991")
        val movie3 = Movie("Shaun the Sheep", "Animation", "2015")
        val movie4 =  Movie("Aliens", "Science Fiction", "1986" )
        val movie5= Movie("Iron Man", "Action & Adventure", "2008")
        val movie6 = Movie("Up", "Animation", "2009")
        val movie7 = Movie("Chicken Run", "Animation", "2000")
        val movie8 =  Movie("Goldfinger", "Action & Adventure", "1965")
        val movie9 = Movie("Crouella", "Animation", "2020")
        val movie10 = Movie("Miki Mouse", "Animation", "2000")


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
