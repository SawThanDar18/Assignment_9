package com.example.assignment_9.mvp.presenters

import com.example.assignment_9.fragments.BaseFragment
import com.example.assignment_9.mvp.views.MovieDetailView
import com.example.assignment_9.utils.EM_NULL_RESPONSE

class MovieDetailPresenter: BasePresenter<MovieDetailView>() {

    fun onUiReady(fragment: BaseFragment, id: Int) {
        if (id != null) {
            model.getMovieDetail(id, {
                view.displayMovieDetail(it)
            }, {
                view.errorMessage(it)
            })
        }

        model.getSimilarMovies(id, {
            view.displaySimilarMovies(it)
        }, {
            view.errorMessage(it)
        })
    }

    fun playTrailer(videoId: String){
        if(videoId.isNullOrEmpty()){
            view.errorMessage(EM_NULL_RESPONSE)
        }
        else{
            view.showTrailers()
        }
    }
}