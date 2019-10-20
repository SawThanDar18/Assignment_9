package com.example.assignment_9.mvp.presenters

import androidx.lifecycle.Observer
import com.example.assignment_9.fragments.BaseFragment
import com.example.assignment_9.mvp.views.MovieSearchView

class MovieSearchPresenter: BasePresenter<MovieSearchView>() {

    private lateinit var fragment: BaseFragment

    fun onUiReady(fragment: BaseFragment) {

        this.fragment = fragment

        model.getAllMovies()
            .observe(this.fragment, Observer {
                view.displayMovies(it)
            })
    }
}