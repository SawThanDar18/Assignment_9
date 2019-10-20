package com.example.assignment_9.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment_9.data.models.MovieModel
import com.example.assignment_9.data.models.MovieModelImpl

abstract class BaseActivity: AppCompatActivity() {

    protected lateinit var model: MovieModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        model = MovieModelImpl
    }
}