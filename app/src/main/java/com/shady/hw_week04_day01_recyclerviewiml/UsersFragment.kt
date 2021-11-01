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
import java.util.*

class UsersFragment : Fragment() {

    private lateinit var usersRecylerView: RecyclerView

    private val usersViewModel by lazy {
        ViewModelProvider(this).get(UsersViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_users_list, container, false)

        usersRecylerView = view.findViewById(R.id.usersRecyclerView)

        val linearLayoutManger = LinearLayoutManager(context)
        usersRecylerView.layoutManager = linearLayoutManger

        updateUI()

        return view
    }

    private fun updateUI(){
        val userAdapter = UserAdapter(usersViewModel.users)
        usersRecylerView.adapter = userAdapter
    }

    private inner class UserViewHolder(view: View)
        : RecyclerView.ViewHolder(view), View.OnClickListener{

        //Widgets
        private val usernameTextView: TextView = itemView.findViewById(R.id.usernameTextView)
        private val messageTextView: TextView = itemView.findViewById(R.id.messageTextView)

        //Attributes
        private lateinit var user: Users
        private lateinit var id: UUID
        init {
            itemView.setOnClickListener(this)
        }

        fun bind(user: Users){
            this.user = user

            usernameTextView.text = user.name
            messageTextView.text = user.message
            id = user.id
        }

        override fun onClick(v: View?) {
            Toast.makeText(context, "USER ID: $id", Toast.LENGTH_SHORT)
        }
    }

    private inner class UserAdapter(var users: List<Users>)
        : RecyclerView.Adapter<UserViewHolder>(){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
            val view = layoutInflater.inflate(R.layout.user_list_item, parent, false)
            return UserViewHolder(view)
        }

        override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
            val user = users[position]

            holder.bind(user)
        }

        override fun getItemCount(): Int = users.size

    }
}