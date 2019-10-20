package com.example.assignment_9.mvp.views

import com.example.assignment_9.data.vos.MovieVO

interface MovieSearchView: BaseView {
    fun displayMovies(movies: List<MovieVO>)
    fun errorMessage(message: String)
}