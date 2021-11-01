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


class StoryListFragment : Fragment() {

    private lateinit var storyRecyclerView:RecyclerView

    val storyListViewModel by lazy { ViewModelProvider(this).get(StoryListViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_story_list, container, false)

        storyRecyclerView = view.findViewById(R.id.story_recycler_view)

        val linearLayoutManager = LinearLayoutManager(context)
        storyRecyclerView.layoutManager = linearLayoutManager
        updateUI()

        return view
    }

    fun updateUI(){
        val storyAdapter = StoryAdapter(storyListViewModel.stories)
        storyRecyclerView.adapter = storyAdapter

    }

    private inner class StoryHolder(view: View):RecyclerView.ViewHolder(view), View.OnClickListener {
        private lateinit var story: Story

        private val titleTextView: TextView = itemView.findViewById(R.id.story_title_item)
        private val dateTextView: TextView = itemView.findViewById(R.id.story_date_item)
        private val isReadImageView: ImageView = itemView.findViewById(R.id.is_read_iv)

        init {
            titleTextView.setOnClickListener(this)
            dateTextView.setOnClickListener(this)
        }

        fun bind(story:Story) {
              this.story = story
            titleTextView.text = story.title
            dateTextView.text = story.date.toString()
            isReadImageView.visibility = if(story.isRead){
                View.VISIBLE
            } else{
                View.GONE
            }
        }

        override fun onClick(p0: View?) {

            if (p0 == titleTextView){
                Toast.makeText(context,"the title is ${story.title}",Toast.LENGTH_LONG).show()
            } else{
                Toast.makeText(context,"the date is ${story.date}",Toast.LENGTH_LONG).show()

            }

        }

      }

    private inner class StoryAdapter(var stories:List<Story>):RecyclerView.Adapter<StoryHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryHolder {
             val view = layoutInflater.inflate(R.layout.list_item_story,parent,false)
            return StoryHolder(view)
        }

        override fun onBindViewHolder(holder: StoryHolder, position: Int) {
               val story = stories[position]
               holder.bind(story)
        }

        override fun getItemCount(): Int = stories.size


    }

}


