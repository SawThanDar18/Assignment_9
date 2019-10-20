package com.example.assignment_9.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.assignment_9.network.dataagents.MovieDataAgent
import com.example.assignment_9.network.dataagents.RetrofitAgentImpl
import com.example.assignment_9.persistence.MovieDB

abstract class BaseWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {

    protected val dataAgent: MovieDataAgent = RetrofitAgentImpl

    protected val movieDB = MovieDB.getInstance(context)
}