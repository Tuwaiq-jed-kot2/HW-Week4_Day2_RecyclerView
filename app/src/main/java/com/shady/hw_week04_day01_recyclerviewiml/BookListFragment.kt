package com.shady.hw_week04_day01_recyclerviewiml

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BookListFragment : Fragment() {

    private lateinit var bookRecyclerView: RecyclerView

    private val bookListViewModel
            by lazy {
                ViewModelProvider(this)
                    .get(BookListViewModel::class.java)
            }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.book_list_fragment, container, false)
        bookRecyclerView = view.findViewById(R.id.book_recycler_view)
        bookRecyclerView.layoutManager = LinearLayoutManager(context)
        update()
        return view
    }





    private fun update() {
        val bookAdapter=BookAdapter(bookListViewModel.books)
        bookRecyclerView.adapter=bookAdapter




    }

    private inner class BookHolder(view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener {
        lateinit var book: Book
        private var titleTextView: TextView = itemView.findViewById(R.id.book_title_item)
        private var authorTextView: TextView = itemView.findViewById(R.id.book_author_item)
        private var bookImage: ImageView = itemView.findViewById(R.id.book_image_view_item)

        init {
            titleTextView.setOnClickListener(this)
            authorTextView.setOnClickListener(this)
        }

        fun bind(book: Book) {
            this.book = book
            titleTextView.text = book.title
            authorTextView.text = book.name
            bookImage.visibility


        }

        override fun onClick(v: View?) {
            if (v == titleTextView) {
                Toast.makeText(
                    context, "the the title of the book is " +
                            "$book.title", Toast.LENGTH_LONG
                ).show()
            } else {

                Toast.makeText(
                    context, "the author of the book is " +
                            "$book.author", Toast.LENGTH_LONG
                ).show()

            }


        }
    }

    private inner class BookAdapter(var books:List<Book>):
        RecyclerView.Adapter<BookHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookHolder {
            val view =layoutInflater.inflate(R.layout.list_item_book,parent,false)
            return BookHolder(view)
        }

        override fun onBindViewHolder(holder: BookHolder, position: Int) {
            val book =books[position]
            holder.bind(book)
        }

        override fun getItemCount(): Int =books.size




    }
}

