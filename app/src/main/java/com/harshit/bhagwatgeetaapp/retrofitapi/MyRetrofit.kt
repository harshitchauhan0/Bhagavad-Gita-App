package com.harshit.bhagwatgeetaapp.retrofitapi

import com.harshit.bhagwatgeetaapp.Credentials
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SingeltonRetrofit {
    private val retrofitBuilder: Retrofit.Builder = Retrofit.Builder().baseUrl(Credentials.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())

    private val retrofit: Retrofit = retrofitBuilder.build()

    private val movieApi: ApiRequests = retrofit.create(ApiRequests::class.java)

    fun getApi(): ApiRequests {
        return movieApi
    }
}