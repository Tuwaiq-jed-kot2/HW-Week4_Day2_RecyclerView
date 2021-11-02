
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shahad.Names
import com.example.shahad.R
import com.example.shahad.TopListViewModel
import java.util.jar.Attributes


class topListFragment: Fragment() {

    private lateinit var recyclerView: RecyclerView

    val topListViewModel by lazy {
        ViewModelProvider(this)
            .get(TopListViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

      val view = inflater.inflate(R.layout.fragment_list,container,false)
        recyclerView = view.findViewById(R.id.recycle_view)

        val linearLayoutManager = LinearLayoutManager(context)
            recyclerView.layoutManager = linearLayoutManager

            return view
    }


    }

    private inner class  NameHolder (view: View)
        :RecyclerView.ViewHolder(view),View.OnClickListener{

            private lateinit var name: Names
            val topNames:TextView = itemView.findViewById(R.id.top_student_list)
             val names:TextView = itemView.findViewById(R.id.name_list)

        init {
            topNames.setOnClickListener(this)
            names.setOnClickListener(this)
        }

        fun bind(name: Names){
            this.name=name
            topNames.text=name.tops
            names.text=name.name

        }

        override fun onClick(v: View?) {
          if (v==topNames){
              Toast.makeText(context,"the tops is${name.tops}",Toast.LENGTH_LONG).show()
          }else if (v==names)
              Toast.makeText(context,"the name is ${name.name}",Toast.LENGTH_LONG).show()


        }

        private inner class TopsAdapter (var name:List<Names>)
            :  RecyclerView.Adapter<NameHolder>(){
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameHolder {
                val view = layoutInflater.inflate((R.layout.fragment_list,parent,false)
            }

            override fun onBindViewHolder(holder: NameHolder, position: Int) {
                val names = name[position]
                holder.bind(names)
            }

            override fun getItemCount(): Int = name.size
            }
        }



    }





