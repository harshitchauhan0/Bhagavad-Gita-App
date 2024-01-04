package com.harshit.bhagwatgeetaapp.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Chinmay(
    @SerializedName("author")
    @Expose
    val author: String = "",
    @SerializedName("hc")
    @Expose
    val hc: String = ""
)