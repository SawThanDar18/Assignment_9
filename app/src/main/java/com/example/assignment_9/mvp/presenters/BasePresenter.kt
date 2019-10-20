package com.example.assignment_9.mvp.presenters

import androidx.lifecycle.ViewModel
import com.example.assignment_9.data.models.MovieModelImpl
import com.example.assignment_9.mvp.views.BaseView

abstract class BasePresenter<T: BaseView>: ViewModel()  {

    protected val model = MovieModelImpl

    protected lateinit var view: T

    fun initPresenter(view: T) {
        this.view = view
    }
}