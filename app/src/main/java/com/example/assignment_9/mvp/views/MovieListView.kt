package com.example.assignment_9.mvp.views

import com.example.assignment_9.data.vos.MovieVO

interface MovieListView: BaseView {
    fun showTopRatedMovie(movies: List<MovieVO>)
    fun showPopularMovie(movies: List<MovieVO>)
    fun showUpcomingMovie(movies: List<MovieVO>)
    fun showNowPlayingMovie(movies: List<MovieVO>)
    fun errorMessage(errorMessage: String)
}