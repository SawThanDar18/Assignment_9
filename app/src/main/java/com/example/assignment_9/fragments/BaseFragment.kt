package com.example.assignment_9.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.assignment_9.data.models.MovieModel
import com.example.assignment_9.data.models.MovieModelImpl

abstract class BaseFragment: Fragment() {

    private lateinit var model: MovieModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        model = MovieModelImpl
    }
}