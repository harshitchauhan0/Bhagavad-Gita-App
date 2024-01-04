package com.harshit.bhagwatgeetaapp.models

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class MyChapter(
    @SerializedName("chapter_number")
    @Expose
    var chapterNumber: Int? = null,

    @SerializedName("verses_count")
    @Expose
    var versesCount: Int? = null,

    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("translation")
    @Expose
    var translation: String? = null,

    @SerializedName("transliteration")
    @Expose
    var transliteration: String? = null,

    @SerializedName("meaning")
    @Expose
    var meaning: Meaning? = null,

    @SerializedName("summary")
    @Expose
    var summary: Summary? = null
)

