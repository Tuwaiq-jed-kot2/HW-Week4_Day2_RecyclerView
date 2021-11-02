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

class EmployeeFragment : Fragment() {

    private lateinit var EmpRcView: RecyclerView

    val employeeViewModel by lazy { ViewModelProvider(this).get(EmployeeViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_employee, container, false)

        EmpRcView = view.findViewById(R.id.recyclerViewEmploye)
        val linearLayoutManager = LinearLayoutManager(context)
        EmpRcView.layoutManager = linearLayoutManager

        adapterUI()



        return view
    }
    fun adapterUI(){
        val empAdapter=EmpAdapter(employeeViewModel.employee)
        EmpRcView.adapter=empAdapter
    }

    private inner class EmpViewHolder(view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener {
        private lateinit var emp: EmpData
        val nameView: TextView = itemView.findViewById(R.id.nameTemView)
        val dateView: TextView = itemView.findViewById(R.id.dateTempView)
        val roomView: TextView =itemView.findViewById(R.id.roomTempView)
        val imgView: ImageView =itemView.findViewById(R.id.imgTempVeiw)

        init {
            nameView.setOnClickListener(this)
            dateView.setOnClickListener(this)
            roomView.setOnClickListener (this)
        }

        fun bind(emp: EmpData) {
            this.emp = emp
            nameView.text = emp.randomName
            dateView.text = emp.date.toString()
            roomView.text=emp.roomNum.toString()
            imgView.visibility=if(emp.atWork){
                View.VISIBLE
            }else{
                View.GONE
            }

        }

        override fun onClick(p0: View?) {
            if (p0 == nameView) {
                Toast.makeText(context, "the Dr.name is:  ${emp.randomName}", Toast.LENGTH_LONG).show()
            } else if (p0 == dateView) {
                Toast.makeText(context, "date:  ${emp.date}", Toast.LENGTH_LONG).show()
            }
            else if (p0==roomView){
                Toast.makeText(context, "he work in room number:  ${emp.roomNum}", Toast.LENGTH_LONG).show()
            }else if (p0==imgView) {
                Toast.makeText(context, "AT WORK", Toast.LENGTH_LONG).show()
            }
        }
    }
    private inner class EmpAdapter(var employee: List<EmpData>) : RecyclerView.Adapter<EmpViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmpViewHolder {
            val view = layoutInflater.inflate(R.layout.emp_templet, parent, false)

            return EmpViewHolder(view)
        }

        override fun onBindViewHolder(holder: EmpViewHolder, position: Int) {
            val item = employee[position]
            holder.bind(item)
        }

        override fun getItemCount(): Int = employee.size

    }


}