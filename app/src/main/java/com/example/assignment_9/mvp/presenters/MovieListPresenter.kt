package com.example.assignment_9.mvp.presenters

import androidx.lifecycle.Observer
import com.example.assignment_9.fragments.BaseFragment
import com.example.assignment_9.mvp.views.MovieListView

class MovieListPresenter: BasePresenter<MovieListView>(){

    fun onUiReady(fragment: BaseFragment) {
        model.getTopRatedMovies()
            .observe(fragment, Observer {
                view.showTopRatedMovie(it)
            })

        model.getPopularMovies()
            .observe(fragment, Observer {
                view.showPopularMovie(it)
            })

        model.getUpComingMovies()
            .observe(fragment, Observer {
                view.showUpcomingMovie(it)
            })

        model.getNowPlayingMovies()
            .observe(fragment, Observer {
                view.showNowPlayingMovie(it)
            })
    }


}