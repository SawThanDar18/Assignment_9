package com.example.assignment_9.data.vos

import com.google.gson.annotations.SerializedName

data class TrailerVO(

    @SerializedName("id")
    val id: Int,
    @SerializedName("iso_639_1")
    val iso_639_1: String,
    @SerializedName("iso_3166_1")
    val iso_3166_1: String,
    @SerializedName("key")
    val key: String,
    @SerializedName("name")
    val trailerName: String,
    @SerializedName("site")
    val site: String,
    @SerializedName("size")
    val size: Int,
    @SerializedName("type")
    val type: String
)