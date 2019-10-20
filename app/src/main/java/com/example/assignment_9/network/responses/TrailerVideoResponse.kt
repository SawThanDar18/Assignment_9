package com.example.assignment_9.network.responses

import com.example.assignment_9.data.vos.TrailerVO
import com.google.gson.annotations.SerializedName

data class TrailerVideoResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("results")
    val results: List<TrailerVO>
)