package com.example.assignment_9.mvp.presenters

import com.example.assignment_9.delegates.ItemClicked
import com.example.assignment_9.mvp.views.MainView

class MainPresenter: BasePresenter<MainView>(), ItemClicked {

    override fun onClicked(movieId: Int) {
        view.navigateToMovieDetail(movieId)
    }
}