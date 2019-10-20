package com.example.assignment_9.network

import com.example.assignment_9.data.vos.MovieDetailVO
import com.example.assignment_9.network.responses.*
import com.example.assignment_9.utils.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {

    @GET(GET_NOW_PLAYING)
    fun getNowPlayingMovies(@Query(PARAM_PAGE) page:Int = 1): Call<GetNowPlayingMovieResponse>

    @GET(GET_POPULAR)
    fun getPopularMovies(@Query(PARAM_PAGE) page:Int = 1): Call<GetPopularMovieResponse>

    @GET(GET_TOP_RATED)
    fun getTopRatedMovies(@Query(PARAM_PAGE) page:Int = 1): Call<GetTopRatedMovieResponse>

    @GET(GET_UPCOMING)
    fun getUpComingMovies(@Query(PARAM_PAGE) page:Int = 1): Call<GetUpcomingMovieResponse>

    @GET(GET_SIMILAR_MOVIES)
    fun getSimilarMovies(@Path("id") id: Int): Call<GetSimilarMovieResponse>

    @GET(GET_VIDEOS)
    fun getTrailer(@Path("id") id: Int): Call<TrailerVideoResponse>

    @GET(GET_MOVIE_DETAIL)
    fun getMovieDetail(@Path("id") id: Int): Call<MovieDetailVO>

}