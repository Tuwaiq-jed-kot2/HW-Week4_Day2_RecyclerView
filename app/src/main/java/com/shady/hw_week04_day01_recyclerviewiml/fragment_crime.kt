package com.example.criminalintent

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.shady.hw_week04_day01_recyclerviewiml.R

class CrimeFragment : Fragment(){
    private lateinit var crime:Crime
    private lateinit var titleEditText: EditText
    private lateinit var dateBtn:Button
    private lateinit var isSolvedCheckBox: CheckBox
    //جزء الفراقمنت//
    override fun onCreateView(
        inflater: LayoutInflater,
        //الربط
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.fragment_crime,container,false )

        titleEditText=view.findViewById(R.id.crime_title)
        dateBtn=view.findViewById(R.id.crime_date)
        isSolvedCheckBox=view.findViewById(R.id.crime_solved)

        dateBtn.apply { text= crime.date.toString()
            isEnabled=false
            //شكل بس لو كان انيبل


        }

        return view
//جزء الفراقمنت
        //ربط الكلاس مع xml
    }
    override fun onStart (){
        super.onStart()

        val textWatcher= object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {


                //i will do noitoging
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                Log.d("SARA",s.toString())
                crime.title=s.toString()
            }

            override fun afterTextChanged(s: Editable?) {

            }

        }
        titleEditText.addTextChangedListener(textWatcher)
        isSolvedCheckBox.setOnCheckedChangeListener { _, isChecked ->
            //عشان يرةحالايؤرورؤ اجط_
            crime.isSolved=isChecked
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crime=Crime()
        //انشلايز
    }





}







