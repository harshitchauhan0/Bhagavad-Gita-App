package com.harshit.bhagwatgeetaapp.retrofitapi

import com.harshit.bhagwatgeetaapp.models.MyChapter
import com.harshit.bhagwatgeetaapp.models.MyShlok
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiRequests {

    @GET("chapter/{ch}")
    fun getChapter(@Path("ch") a:String) : Call<MyChapter>

    @GET("slok/{ch}/{sl}")
    fun getShlokFromChapter(@Path("ch") a:String, @Path("sl") b:String): Call<MyShlok>

}