package com.harshit.bhagwatgeetaapp.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.harshit.bhagwatgeetaapp.Credentials
import com.harshit.bhagwatgeetaapp.R
import com.harshit.bhagwatgeetaapp.activities.ShlokActivity

class VerseAdapter(private val context: Context, private val count:Int,private val chapter:Int):RecyclerView.Adapter<VerseAdapter.MyViewHolder>() {

    inner class MyViewHolder(item: View):RecyclerView.ViewHolder(item){
        var textView:TextView
        init {
            textView = item.findViewById(R.id.text)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.verse,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return count
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val temp = position + 1
        holder.textView.text = temp.toString()
        holder.itemView.setOnClickListener {
            val intent = Intent(context, ShlokActivity::class.java)
            intent.putExtra(Credentials.SHLOK,temp)
            intent.putExtra(Credentials.CHAPTER,chapter)
            context.startActivity(intent)
        }
    }
}