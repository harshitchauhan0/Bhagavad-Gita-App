package com.harshit.bhagwatgeetaapp.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.harshit.bhagwatgeetaapp.Credentials
import com.harshit.bhagwatgeetaapp.activities.ChapterActivity
import com.harshit.bhagwatgeetaapp.databinding.HomeScreenItemBinding

class MyHomeAdapter(private val context: Context,private val array: MutableList<Int>):
    RecyclerView.Adapter<MyHomeAdapter.MyViewHolder>() {
    private lateinit var binding:HomeScreenItemBinding
    inner class MyViewHolder(var binding: HomeScreenItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = HomeScreenItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return array.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val a = array[position].toString()
        holder.binding.item.text = "Chapter $a"
        holder.binding.root.setOnClickListener {
            val intent = Intent(context, ChapterActivity::class.java)
            intent.putExtra(Credentials.CHAPTER,array[position])
            context.startActivity(intent)
        }
    }

}