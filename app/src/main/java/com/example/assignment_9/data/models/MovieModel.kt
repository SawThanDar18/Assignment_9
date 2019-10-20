package com.example.assignment_9.data.models

import androidx.lifecycle.LiveData
import com.example.assignment_9.data.vos.*

interface MovieModel {

    fun getUpComingMovies(): LiveData<List<MovieVO>>
    fun getPopularMovies(): LiveData<List<MovieVO>>
    fun getTopRatedMovies(): LiveData<List<MovieVO>>
    fun getNowPlayingMovies(): LiveData<List<MovieVO>>
    fun getAllMovies(): LiveData<List<MovieVO>>

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

    fun getSearchMovie(title: String): List<MovieVO>
}