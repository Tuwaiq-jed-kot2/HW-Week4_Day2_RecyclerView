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

class ListOfFragment : Fragment() {
    private lateinit var infoRecycleView:RecyclerView

    val infoListViewModel by lazy { ViewModelProvider(this).get(InfoViewModel::class.java)}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_list_of, container, false)
        infoRecycleView= view.findViewById(R.id.info_recyclev)
        val linearLayoutManager=LinearLayoutManager(context)
        infoRecycleView.layoutManager=linearLayoutManager
        update()
        return view
    }

    private fun update(){
        val infoAdapter=InfoAdapter(infoListViewModel.infos)
        infoRecycleView.adapter=infoAdapter

    }
   private inner class InfoHolder(view: View):RecyclerView.ViewHolder(view),View.OnClickListener{

       lateinit var info:Info
      private var nameInfo:TextView=itemView.findViewById(R.id.name_view)
       private var idInfo:TextView=itemView.findViewById(R.id.id_view)

       init {
           nameInfo.setOnClickListener(this)
           idInfo.setOnClickListener(this)
       }

       fun bind(info:Info){
           this.info= Info()
           nameInfo.text=info.name
           idInfo.text=info.id.toString()
       }

       override fun onClick(v: View?) {
           if (v == nameInfo) {
               Toast.makeText(context, "the name is ${info.name}", Toast.LENGTH_LONG)
                   .show()
           } else {
               if (v == idInfo) {

                   Toast.makeText(context, "the id is ${info.id}", Toast.LENGTH_LONG).show()
               }
           }

       }

   }
    private inner class InfoAdapter(var infos:List<Info>):RecyclerView.Adapter<InfoHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoHolder {
         val view=layoutInflater.inflate(R.layout.list_of_item,parent,false)

            return InfoHolder(view)
        }

        override fun onBindViewHolder(holder: InfoHolder, position: Int) {
         val info1=infos[position]
          holder.bind(info1)


        }

        override fun getItemCount(): Int =infos.size


    }

}
