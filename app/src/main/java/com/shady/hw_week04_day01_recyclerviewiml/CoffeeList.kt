package com.shady.hw_week04_day01_recyclerviewiml

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

class CoffeeList : Fragment() {

    private lateinit var coffeeRecyclerView: RecyclerView

    private val coffeeListViewModel by lazy { ViewModelProvider(this).get(CoffeeListViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_coffee_list, container, false)
        coffeeRecyclerView = view.findViewById(R.id.coffee_recycler_view)
        val linearLayoutManager = LinearLayoutManager(context)
        coffeeRecyclerView.layoutManager = linearLayoutManager
        coffeeRecyclerView.adapter = CoffeeAdapter(coffeeListViewModel.coffeeDrinks)


        return view
    }

    private inner class CoffeeViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        private lateinit var coffee: Coffee

         private val coffeeNameTextView: TextView = itemView.findViewById(R.id.coffee_name_tv)
          private val coffeePriceTextView: TextView = itemView.findViewById(R.id.coffee_price_tv)

        init {
            coffeeNameTextView.setOnClickListener(this)
            coffeePriceTextView.setOnClickListener(this)
        }

         fun bind(coffee: Coffee) {
             this.coffee = coffee
             coffeeNameTextView.text = coffee.name
             coffeePriceTextView.text = coffee.price.toString()
         }

        override fun onClick(p0: View?) {
            if (p0 == coffeeNameTextView) {
                Toast.makeText(context, coffee.name, Toast.LENGTH_SHORT).show()
            } else if (p0 == coffeePriceTextView) {
                Toast.makeText(context, coffee.price.toString(), Toast.LENGTH_SHORT).show()
            }
        }

    }

    private inner class CoffeeAdapter(var coffee: List<Coffee>) : RecyclerView.Adapter<CoffeeViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeeViewHolder {
            val view = layoutInflater.inflate(R.layout.coffee_list_item, parent, false)
            return CoffeeViewHolder(view)
        }

        override fun onBindViewHolder(holder: CoffeeViewHolder, position: Int) {
            val coffee1 = coffee[position]
            holder.bind(coffee1)
        }

        override fun getItemCount(): Int = coffee.size

    }
}
