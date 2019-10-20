package com.example.assignment_9.data.vos

import com.google.gson.annotations.SerializedName

data class CompanyVO (
    @SerializedName("id")
    val id: Int,

    @SerializedName("logo_path")
    var logoPath: String?,

    @SerializedName("name")
    val name: String,

    @SerializedName("origin_country")
    val originCountry: String
)