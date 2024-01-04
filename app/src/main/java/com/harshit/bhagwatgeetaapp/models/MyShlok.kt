package com.harshit.bhagwatgeetaapp.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MyShlok(
    @SerializedName("chapter")
    @Expose
    var chapter: Int? = null,

    @SerializedName("verse")
    @Expose
    var verse: Int? = null,

    @SerializedName("slok")
    @Expose
    var slok: String? = null,

    @SerializedName("transliteration")
    @Expose
    var transliteration:String? = null,

    @SerializedName("chinmay")
    @Expose
    var chinmay: Chinmay? = null,

    @SerializedName("san")
    @Expose
    var san: San? =null
)
