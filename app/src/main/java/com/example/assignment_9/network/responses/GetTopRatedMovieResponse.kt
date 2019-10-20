package com.example.assignment_9.network.responses

import com.example.assignment_9.data.vos.MovieVO
import com.google.gson.annotations.SerializedName

data class GetTopRatedMovieResponse(

    @SerializedName("page")
    val page:Int,
    @SerializedName("total_results")
    val totalResults: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("results")
    val results: List<MovieVO>
)