package com.shady.hw_week04_day01_recyclerviewiml

import android.content.ContentValues.TAG
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
import com.shady.hw_week04_day01_recyclerviewiml.Student as Students


class StudentListFragment : Fragment() {

    private lateinit var studentRecyclerView: RecyclerView
    private lateinit var boy: RecyclerView

    private val studentViewModel: StudentListViewModel by lazy { ViewModelProvider(this).get(StudentListViewModel::class.java)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_student_list, container, false)

        studentRecyclerView =
            view.findViewById(R.id.student_recycler_view) as RecyclerView
        studentRecyclerView.layoutManager = LinearLayoutManager(context)

        updateUI()

        return view
    }

    private fun updateUI() {
        val studentAdapter = studentAdapter(studentViewModel.students)
        studentRecyclerView.adapter = studentAdapter
    }

    private inner class studentHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        private lateinit var student: Students

        private val titleTextView: TextView = itemView.findViewById(R.id.student_title)
        private val dateTextView: TextView = itemView.findViewById(R.id.day_date)
        private val solvedImageView: ImageView = itemView.findViewById(R.id.boy)

        init {
            titleTextView.setOnClickListener(this)
            dateTextView.setOnClickListener(this)
        }

        fun bind(student: Students) {
            this.student = student
            titleTextView.text = this.student.title
            dateTextView.text = this.student.date.toString()
            solvedImageView.visibility = if (student.isPresent) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }

        override fun onClick(v: View?) {
            if (v == titleTextView) {
                Toast.makeText(context, "${student.title} clicked!", Toast.LENGTH_SHORT)
                    .show()
            }else if (v == dateTextView){
                Toast.makeText(context, "${student.date} clicked!", Toast.LENGTH_SHORT)
            }else if (v==solvedImageView){
                Toast.makeText(context, "${student.isPresent} ", Toast.LENGTH_SHORT)
            }
        }

    private inner class StudentAdapter(var students: List<Students>)
        : RecyclerView.Adapter<studentHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
                : studentHolder {
            val view = layoutInflater.inflate(R.layout.list_item_student, parent, false)
            return studentHolder(view)
        }
        override fun getItemCount() = students.size
        override fun onBindViewHolder(holder: studentHolder, position: Int) {
            val student = students[position]
            holder.bind(student)
        }
    }
}