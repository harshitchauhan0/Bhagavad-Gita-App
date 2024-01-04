package com.harshit.bhagwatgeetaapp.models


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Meaning(
    @SerializedName("en")
    @Expose
    var en: String? = null,

    @SerializedName("hi")
    @Expose
    var hi: String? = null
)
