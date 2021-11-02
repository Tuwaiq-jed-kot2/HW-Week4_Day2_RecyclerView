package com.shady.hw_week04_day01_recyclerviewiml

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.DividerItemDecoration





class MovieListFragment : Fragment() {

    private  lateinit var movieRecyclerView: RecyclerView
    private val movieListViewModel by lazy {ViewModelProvider (this ).get(MovieListViewModel::class.java)}

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

        movieRecyclerView.addItemDecoration(
                DividerItemDecoration(
                    context,
                    LinearLayoutManager.VERTICAL
                )
        )
        movieRecyclerView.adapter = movieAdapter
    }

    private inner class MovieHolder(view:View) : RecyclerView.ViewHolder(view),View.OnClickListener{

        private lateinit var movie: Movie

       val movieNameTextView:TextView=itemView.findViewById(R.id.movieName)
       val yearTextView:TextView=itemView.findViewById(R.id.year)
       val generTextView:TextView=itemView.findViewById(R.id.gener)




        init {
            movieNameTextView.setOnClickListener(this)
            yearTextView.setOnClickListener(this)
            generTextView.setOnClickListener(this)
        }
       fun bind(movie : Movie){
           this.movie=movie
           movieNameTextView.text=movie.movieName
           yearTextView.text=movie.year
           generTextView.text=movie.genre

       }

        override fun onClick(v: View?) {
            if (v== generTextView){
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
