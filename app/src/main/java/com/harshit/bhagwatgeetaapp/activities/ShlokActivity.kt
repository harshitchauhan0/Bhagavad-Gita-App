package com.harshit.bhagwatgeetaapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.harshit.bhagwatgeetaapp.Credentials
import com.harshit.bhagwatgeetaapp.R
import com.harshit.bhagwatgeetaapp.databinding.ActivityShlokBinding
import com.harshit.bhagwatgeetaapp.models.MyShlok
import com.harshit.bhagwatgeetaapp.retrofitapi.SingeltonRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShlokActivity : AppCompatActivity() {
    private lateinit var binding:ActivityShlokBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_shlok)
        val shlok = intent.getIntExtra(Credentials.SHLOK,1)
        val chapter = intent.getIntExtra(Credentials.CHAPTER,1)
        val api = SingeltonRetrofit.getApi()
        api.getShlokFromChapter(chapter.toString(),shlok.toString()).enqueue(object :Callback<MyShlok>{
            override fun onResponse(call: Call<MyShlok>, response: Response<MyShlok>) {
                val res = response.body()
                res?.let {
                    with(binding){
                        chapterNumber.text = chapter.toString()
                        shlokNumber.text = shlok.toString()
                        shlokInSanskrit.text = it.slok
                        shlokTranslation.text = it.transliteration
                        shlokExp.text = it.chinmay?.hc
                        shlokExpInEnglish.text = it.san?.et
                    }
                }
            }

            override fun onFailure(call: Call<MyShlok>, t: Throwable) {
                Log.v("TAG",t.message.toString())
            }
        })

    }
}