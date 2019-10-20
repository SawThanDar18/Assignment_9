package com.example.assignment_9.network.dataagents

import com.example.assignment_9.data.vos.*
import com.example.assignment_9.network.responses.TrailerVideoResponse

interface MovieDataAgent {
    fun getNowPlayingMovies(
        page: Int,
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    )
    fun getPopularMovies(
        page: Int,
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    )
    fun getTopRatedMovies(
        page: Int,
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    )
    fun getUpComingMovies(
        page: Int,
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    )
    fun getTrailerVideos(
        movieId: Int,
        onSuccess: (TrailerVideoResponse) -> Unit,
        onFailure: (String) -> Unit
    )
    fun getMovieDetail(
        id: Int,
        onSuccess: (MovieDetailVO) -> Unit,
        onFailure: (String) -> Unit
    )
    fun getSimilarMovies(
        id: Int,
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    )
}