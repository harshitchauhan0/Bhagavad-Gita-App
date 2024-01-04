package com.harshit.bhagwatgeetaapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.harshit.bhagwatgeetaapp.Credentials
import com.harshit.bhagwatgeetaapp.R
import com.harshit.bhagwatgeetaapp.adapters.VerseAdapter
import com.harshit.bhagwatgeetaapp.databinding.ActivityChapterBinding
import com.harshit.bhagwatgeetaapp.models.MyChapter
import com.harshit.bhagwatgeetaapp.retrofitapi.SingeltonRetrofit
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChapterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChapterBinding
    private lateinit var adapter: VerseAdapter
    private lateinit var verses:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_chapter)

        val ch = intent.getIntExtra(Credentials.CHAPTER,1)
        val context = this
        binding.recyclerView.layoutManager = GridLayoutManager(this,6)
        CoroutineScope(Dispatchers.IO).launch {
            val api = SingeltonRetrofit.getApi()
            api.getChapter(ch.toString()).enqueue(object : Callback<MyChapter>{
                override fun onResponse(call: Call<MyChapter>, response: Response<MyChapter>) {
                    val chapter:MyChapter?  = response.body()
                    binding.chapterNum.text = chapter?.chapterNumber.toString()
                    verses = chapter?.versesCount.toString()
                    adapter = VerseAdapter(context,verses.toInt(),ch)
                    binding.recyclerView.adapter = adapter
                    binding.slokNum.text = chapter?.versesCount.toString()
                    binding.chapterName.text = chapter?.name + "(${chapter?.translation})"
                    binding.meaning.text = chapter?.meaning?.en
                    binding.summaryHindi.text = chapter?.summary?.hi
                    binding.summaryEnglish.text = chapter?.summary?.en
                }

                override fun onFailure(call: Call<MyChapter>, t: Throwable) {
                    Log.v("TAG",t.message.toString())
                }
            })
        }
    }
}