package com.example.assignment_9.mvp.views

import com.example.assignment_9.data.vos.MovieDetailVO
import com.example.assignment_9.data.vos.MovieVO

interface MovieDetailView: BaseView {
    fun displayMovieDetail(movieDetail: MovieDetailVO)
    fun displaySimilarMovies(movies: List<MovieVO>)
    fun showTrailers()
    fun errorMessage(errorMessage: String)
}