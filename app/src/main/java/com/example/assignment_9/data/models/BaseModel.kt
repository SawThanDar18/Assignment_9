package com.example.assignment_9.data.models

import android.content.Context
import com.example.assignment_9.network.dataagents.MovieDataAgent
import com.example.assignment_9.network.dataagents.RetrofitAgentImpl
import com.example.assignment_9.persistence.MovieDB

abstract class BaseModel {

    protected val dataAgent: MovieDataAgent = RetrofitAgentImpl

    protected lateinit var movieDB: MovieDB

    fun initDatabase(context: Context){
        movieDB = MovieDB.getInstance(context)
    }

}