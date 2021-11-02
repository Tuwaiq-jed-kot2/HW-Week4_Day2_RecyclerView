package com.example.jforjop

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
import com.example.criminalintent.Jop
import com.example.criminalintent.JopListViewModel


class JopListFragment : Fragment() {

    private lateinit var jopRecyclerView: RecyclerView

    val  jopListViewModel by lazy { ViewModelProvider(this).get(JopListViewModel::class.java) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

val view=inflater.inflate(R.layout.fragment_jop_list,container,false)
        jopRecyclerView=view.findViewById(R.id.job_recycler_view)

        val linearLayoutManager=LinearLayoutManager(context)

        jopRecyclerView.layoutManager=linearLayoutManager
        updateUI()

        return view
    }
    private fun updateUI(){
        val jopAdapter= JopAdapter(jopListViewModel.jops)
        jopRecyclerView.adapter=jopAdapter

    }
private inner class JopViewHolder(view:View):RecyclerView.ViewHolder(view),View.OnClickListener{
   private lateinit var jop:Jop
   private val titleTextView:TextView= itemView.findViewById(R.id.jop_title_item)
   private val dateTextView:TextView= itemView.findViewById(R.id.jop_date_item)
    private val isTakenImageView:ImageView=itemView.findViewById(R.id.is_taken_iv)
    private val isNotTakenIv:ImageView=itemView.findViewById(R.id.is_not_taken_iv)
    init {
        titleTextView.setOnClickListener(this)
        dateTextView.setOnClickListener(this)
        isTakenImageView.setOnClickListener(this)
        isNotTakenIv.setOnClickListener(this)
    }


    fun blind(jop: Jop){
        this.jop= jop
        titleTextView.text=jop.title
        dateTextView.text=jop.date.toString()


        isNotTakenIv.visibility=if (!jop.istaken)View.VISIBLE else View.GONE

        isTakenImageView.visibility=if (jop.istaken)View.VISIBLE else View.GONE


    }
    override fun onClick(w0: View?) {
        if (w0 == titleTextView) {
            Toast.makeText(context, "the subject is ${jop.title}", Toast.LENGTH_LONG).show()
        }else if (w0==dateTextView){
            Toast.makeText(context, "the date is ${jop.date}", Toast.LENGTH_LONG).show()
        }else if (w0==isTakenImageView){
                     if (jop.istaken){
                         Toast.makeText(context,"sorry, this jop is already taken",Toast.LENGTH_LONG).show()
                     }

        }else if(w0==isNotTakenIv){
            if (!jop.istaken) Toast.makeText(context," this jop is not taken yet ",Toast.LENGTH_LONG).show()
        }
    }

}









private inner class JopAdapter(var jops:List<Jop>):RecyclerView.Adapter<JopViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JopViewHolder {
       val view=layoutInflater.inflate(R.layout.list_item_jop,parent,false)
    return JopViewHolder(view)
    }

    override fun onBindViewHolder(holder: JopViewHolder, position: Int) {
       val jop=jops[position]
        holder.blind(jop)
    }

    override fun getItemCount(): Int = jops.size

}





                }


