package com.example.assignment_9.workers

import android.content.Context
import androidx.work.WorkerParameters

class GetTopRatedMoviesWorker(context: Context, workerParams: WorkerParameters) :
    BaseWorker(context, workerParams) {
    override fun doWork(): Result {
        var result = Result.failure()
        dataAgent.getTopRatedMovies(page = 1,
            onSuccess = {
                movieDB.movieDao().insertMovies(it)
                result = Result.success()
            }, onFailure = {
                result = Result.failure()
            }
        )
        return result
    }

}