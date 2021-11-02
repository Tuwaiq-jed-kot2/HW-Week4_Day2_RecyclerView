package com.example.movielist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shady.hw_week04_day01_recyclerviewiml.R


class MovieListFragment : Fragment() {

    private  lateinit var movieRecyclerView: RecyclerView
    val movieListViewModel by lazy {ViewModelProvider (this ).get(MovieListViewModel::class.java)}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =inflater.inflate(R.layout.fragment_movie_list, container, false)

        movieRecyclerView=view.findViewById(R.id.movie_Recycler_View)
        val linearlayoutManger =LinearLayoutManager(context)
        movieRecyclerView.layoutManager = linearlayoutManger

        updateUI()
        return view

    }

    private fun updateUI() {

        val movieAdapter = MovieAdapter(movieListViewModel.movies)
        movieRecyclerView.adapter = movieAdapter
    }

    private inner class MovieHolder(view:View) : RecyclerView.ViewHolder(view),View.OnClickListener{

        private lateinit var movie: Movie

       val movieNameTextView:TextView=itemView.findViewById(R.id.movieName)
       val yearTextView:TextView=itemView.findViewById(R.id.year)




        init {
            movieNameTextView.setOnClickListener(this)
            yearTextView.setOnClickListener(this)
        }
       fun bind(movie :Movie){
           this.movie=movie
           movieNameTextView.text=movie.movieName
           yearTextView.text=movie.year
       }

        override fun onClick(v: View?) {
            if (v== movieNameTextView){
                if(movie.genre=="Animation"){
                Toast.makeText(context,"The movie is kids friendly",Toast.LENGTH_LONG).show()}
                else
                    Toast.makeText(context,"The movie for adult only",Toast.LENGTH_LONG).show()
            }else if(v == yearTextView){
                Toast.makeText(context,"The movie released in ${movie.year}",Toast.LENGTH_LONG).show()
            }
        }
    }

    private inner class MovieAdapter(var movies: List<Movie>) : RecyclerView.Adapter<MovieHolder>(){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
            val view = layoutInflater.inflate(R.layout.fragment_item, parent, false)
            return MovieHolder(view)
        }

        override fun onBindViewHolder(holder: MovieHolder, position: Int) {
            val movie = movies[position]
            holder.bind(movie)
        }

        override fun getItemCount(): Int = movies.size

    }
}
