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
import java.text.DateFormat
import java.text.DateFormat.SHORT


class ChatFragment : Fragment() {

    private lateinit var chatRc : RecyclerView

    private val chatListViewModel by lazy { ViewModelProvider(this).get(ChatListViewModel::class.java) }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_chat, container, false)
        chatRc = view.findViewById(R.id.chat_rc)
        val linearLayoutManager = LinearLayoutManager(context)
        chatRc.layoutManager = linearLayoutManager
        val chatAdapter = ChatAdapter(chatListViewModel.chat)
        chatRc.adapter = chatAdapter

        return view
    }


    private inner class ChatViewHolder(view:View):RecyclerView.ViewHolder(view), View.OnClickListener{
        private lateinit var user: User
        private val userNameTv : TextView = itemView.findViewById(R.id.user_name_item)
        private val onlineStateTv : TextView = itemView.findViewById(R.id.online_state_item)
        private val dateTv : TextView = itemView.findViewById(R.id.date_item)

        init {

            itemView.setOnClickListener(this)

        }

        fun bind(user: User){
            this.user = user
            userNameTv.text = user.user
            dateTv.text = DateFormat.getTimeInstance(SHORT).format(user.date)
            onlineStateTv.visibility = if (user.onlineState){
                View.VISIBLE
            }else{
                View.GONE
            }

        }

        override fun onClick(v: View?) {

            Toast.makeText(context,"This id: ${user.id} for ${user.user}",Toast.LENGTH_LONG).show()
        }


    }

    private inner class ChatAdapter(var users: List<User>):RecyclerView.Adapter<ChatViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
            val view = layoutInflater.inflate(R.layout.list_item_chat,parent,false)
            return ChatViewHolder(view)
        }

        override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
            val user = users[position]
            holder.bind(user)
        }

        override fun getItemCount(): Int = users.size


    }


}