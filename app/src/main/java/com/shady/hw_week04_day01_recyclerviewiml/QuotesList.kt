package com.shady.hw_week04_day01_recyclerviewiml

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class QuotesList : Fragment() {

    private lateinit var quoteRecyclerView: RecyclerView
    private val quoteListViewModel by lazy { ViewModelProvider(this).get(QuoteViewModel::class.java)}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_quotes_list, container, false)
        quoteRecyclerView = view.findViewById(R.id.quotes_rc)
        val linearLayoutManager = LinearLayoutManager(context)
        quoteRecyclerView.layoutManager = linearLayoutManager
        updateUI()
        return view
    }

    private fun updateUI() {
        val quoteAdapter = QuoteAdapter(quoteListViewModel.quotes)
        quoteRecyclerView.adapter = updateUI(quoteAdapter)
    }

    private inner class QuoteViewHolder(view:View):RecyclerView.ViewHolder(view),View.OnClickListener {

        private lateinit var quote: Quote
        val quoteTv: TextView = itemView.findViewById(R.id.quote_tv)
        val writerTv: TextView = itemView.findViewById(R.id.wrtier_tv)
        val likeBtn:ImageView = itemView.findViewById(R.id.like_btn)

        init {
            likeBtn.setOnClickListener(this)
        }

        fun bind(quote: Quote){
            this.quote= quote
            quoteTv.text = quote.quote
            writerTv.text = quote.writer
        }

        override fun onClick(v: View?) {
            val color =R.color.red_700
            likeBtn.setColorFilter(color)
        }
    }

    private inner class QuoteAdapter(var quotes:List<Quote>):
        RecyclerView.Adapter<QuoteViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
            val view = layoutInflater.inflate(R.layout.item_list, parent,false)
            return QuoteViewHolder(view)
        }

        override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
            val quote = quotes[position]
            holder.bind(quote)
        }

        override fun getItemCount(): Int = quotes.size

    }



    private fun updateUI(quoteAdapter: QuoteAdapter) =
        quoteAdapter


}