package com.example.assignment_9.workers

import android.content.Context
import androidx.work.WorkerParameters

class GetPopularMoviesWorker(context: Context, workerParams: WorkerParameters) :
    BaseWorker(context, workerParams) {
    override fun doWork(): Result {
        var result = Result.failure()
        dataAgent.getPopularMovies(1,
            {
                result = Result.success()
                movieDB.movieDao().insertMovies(it)

            },{
                result = Result.failure()
            }
        )
        return result
    }

}