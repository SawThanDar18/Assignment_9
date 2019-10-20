package com.example.assignment_9.data.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.assignment_9.data.vos.*

object MovieModelImpl : BaseModel(), MovieModel {

    override fun getAllMovies(): LiveData<List<MovieVO>> {
        return Transformations.distinctUntilChanged(movieDB.movieDao().getMovies())
    }

    override fun getSearchMovie(title: String): List<MovieVO> {
        return movieDB.movieDao().getSearchMovie("%$title%")
    }

    override fun getMovieDetail(
        id: Int,
        onSuccess: (MovieDetailVO) -> Unit,
        onFailure: (String) -> Unit
    ) {
        dataAgent.getMovieDetail(id,
            onSuccess= {
                onSuccess(it)
            },
            onFailure= {
                onFailure(it)
            })
    }

    override fun getUpComingMovies(): LiveData<List<MovieVO>> {
        return Transformations.distinctUntilChanged(movieDB.movieDao().getUpcomingMovies())
    }

    override fun getPopularMovies(): LiveData<List<MovieVO>> {
        return Transformations.distinctUntilChanged(movieDB.movieDao().getPopularMovies())
    }

    override fun getTopRatedMovies(): LiveData<List<MovieVO>> {
        return Transformations.distinctUntilChanged(movieDB.movieDao().getTopRatedMovies())
    }

    override fun getSimilarMovies(
        id: Int,
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        dataAgent.getSimilarMovies(id,
            onSuccess= {
                onSuccess(it)
            },
            onFailure= {
                onFailure(it)
            })
    }

    override fun getNowPlayingMovies(): LiveData<List<MovieVO>> {
        return Transformations.distinctUntilChanged(movieDB.movieDao().getNowPlayngMovies())
    }

}