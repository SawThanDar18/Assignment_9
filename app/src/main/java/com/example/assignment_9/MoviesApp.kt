package com.example.assignment_9

import android.app.Application
import androidx.work.*
import com.example.assignment_9.data.models.MovieModelImpl
import com.example.assignment_9.workers.GetNowPlayingMoviesWorker
import com.example.assignment_9.workers.GetPopularMoviesWorker
import com.example.assignment_9.workers.GetTopRatedMoviesWorker
import com.example.assignment_9.workers.GetUpcomingMoviesWorker
import java.util.concurrent.TimeUnit

class MoviesApp: Application() {

    override fun onCreate() {
        super.onCreate()

        MovieModelImpl.initDatabase(applicationContext)

        getNowPlayingOneTime()
        getPopularOneTime()
        getTopRatedOneTime()
        getUpcomingOneTime()
        getNowPlayingPeriodically()
        getPopularPeriodically()
        getTopRatedPeriodically()
        getUpcomingPeriodically()

    }

    private fun getNowPlayingOneTime() {
        val getNowPlayingMoviesWorkRequest = OneTimeWorkRequest
            .Builder(GetNowPlayingMoviesWorker::class.java)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getNowPlayingMoviesWorkRequest)
    }
    private fun getTopRatedOneTime() {
        val getTopRatedMoviesWorkRequest = OneTimeWorkRequest
            .Builder(GetTopRatedMoviesWorker::class.java)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getTopRatedMoviesWorkRequest)
    }
    private fun getPopularOneTime() {
        val getPopularMoviesWorkRequest = OneTimeWorkRequest
            .Builder(GetPopularMoviesWorker::class.java)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getPopularMoviesWorkRequest)
    }
    private fun getUpcomingOneTime() {
        val getUpComingMoviesWorkRequest = OneTimeWorkRequest
            .Builder(GetUpcomingMoviesWorker::class.java)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getUpComingMoviesWorkRequest)
    }

    private fun getNowPlayingPeriodically() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        val getNowShowingMoviesWorkRequest = PeriodicWorkRequest
            .Builder(GetNowPlayingMoviesWorker::class.java,30, TimeUnit.MINUTES)
            .setConstraints(constraints)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getNowShowingMoviesWorkRequest)
    }
    private fun getTopRatedPeriodically() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        val getTopRatedMoviesWorkRequest = PeriodicWorkRequest
            .Builder(GetTopRatedMoviesWorker::class.java,30, TimeUnit.MINUTES)
            .setConstraints(constraints)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getTopRatedMoviesWorkRequest)
    }
    private fun getPopularPeriodically() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        val getPopularMoviesWorkRequest = PeriodicWorkRequest
            .Builder(GetPopularMoviesWorker::class.java,30, TimeUnit.MINUTES)
            .setConstraints(constraints)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getPopularMoviesWorkRequest)
    }
    private fun getUpcomingPeriodically() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        val getUpComingMoviesWorkRequest = PeriodicWorkRequest
            .Builder(GetUpcomingMoviesWorker::class.java,30, TimeUnit.MINUTES)
            .setConstraints(constraints)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getUpComingMoviesWorkRequest)
    }

}