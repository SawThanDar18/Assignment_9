package com.example.assignment_9.network.responses

import com.example.assignment_9.data.vos.MovieVO
import com.google.gson.annotations.SerializedName

data class GetUpcomingMovieResponse(

    @SerializedName("results")
    val results: List<MovieVO>
)