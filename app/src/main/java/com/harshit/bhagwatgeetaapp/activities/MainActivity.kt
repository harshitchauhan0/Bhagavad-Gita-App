package com.harshit.bhagwatgeetaapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.harshit.bhagwatgeetaapp.R
import com.harshit.bhagwatgeetaapp.adapters.MyHomeAdapter
import com.harshit.bhagwatgeetaapp.databinding.ActivityMainBinding
import com.harshit.bhagwatgeetaapp.retrofitapi.SingeltonRetrofit

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MyHomeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.recyclerView.layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.itemAnimator = DefaultItemAnimator()
        val array = mutableListOf<Int>()
        for(i in 1..18) array.add(i)
        adapter = MyHomeAdapter(this, array)
        binding.recyclerView.adapter = adapter

    }
}