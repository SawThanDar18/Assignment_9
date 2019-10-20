package com.example.assignment_9.data.vos

import com.google.gson.annotations.SerializedName

data class CountryVO (
    @SerializedName("iso_3166_1")
    val iso: String,

    @SerializedName("name")
    val name: String
)