package com.harshit.bhagwatgeetaapp.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class San(
    @SerializedName("author")
    @Expose
    val author: String = "",
    @SerializedName("et")
    @Expose
    val et: String = ""
)