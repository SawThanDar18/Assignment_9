package com.example.assignment_9.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.assignment_9.data.vos.MovieVO

@Dao
abstract class MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertMovies(movies: List<MovieVO>): LongArray

    @Query("SELECT * FROM movies")
    abstract fun getMovies(): LiveData<List<MovieVO>>

    @Query("SELECT * FROM movies ORDER BY vote_average DESC LIMIT 20")
    abstract fun getTopRatedMovies(): LiveData<List<MovieVO>>

    @Query("SELECT * FROM movies ORDER BY popularity DESC LIMIT 20")
    abstract fun getPopularMovies(): LiveData<List<MovieVO>>

    @Query("SELECT * FROM movies")
    abstract fun getUpcomingMovies(): LiveData<List<MovieVO>>

    @Query("SELECT * FROM movies")
    abstract fun getNowPlayngMovies(): LiveData<List<MovieVO>>

    @Query("SELECT * FROM movies WHERE title LIKE :title")
    abstract fun getSearchMovie(title: String): List<MovieVO>
}