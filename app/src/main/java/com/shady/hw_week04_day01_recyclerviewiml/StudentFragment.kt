package com.shady.hw_week04_day01_recyclerviewiml

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText



class StudentFragment : Fragment() {
    private lateinit var student: Student
    private lateinit var titleField: EditText
    private lateinit var dateButton: Button
    private lateinit var presentCheckBox: CheckBox


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        student = Student()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_student, container, false)
        titleField = view.findViewById(R.id.student_title) as EditText
        dateButton = view.findViewById(R.id.Day_date) as Button
        presentCheckBox = view.findViewById(R.id.student_present) as CheckBox
        dateButton.apply {
            text = student.date.toString()
            isEnabled = false
        }
        return view
    }

    override fun onStart() {
        super.onStart()
        val titleWatcher = object : TextWatcher {

            override fun beforeTextChanged(
                sequence: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
                // This space intentionally left blank
            }

            override fun onTextChanged(
                sequence: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {
                student.title = sequence.toString()
            }

            override fun afterTextChanged(sequence: Editable?) {
                // This one too
            }
        }
        titleField.addTextChangedListener(titleWatcher)

        presentCheckBox.apply {
            setOnCheckedChangeListener { _, isChecked ->
                student.isPresent = isChecked
            }
        }
    }
}




