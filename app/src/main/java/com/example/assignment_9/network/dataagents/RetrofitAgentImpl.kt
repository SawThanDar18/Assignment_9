package com.example.assignment_9.network.dataagents

import com.example.assignment_9.data.vos.*
import com.example.assignment_9.network.MoviesApi
import com.example.assignment_9.network.responses.*
import com.example.assignment_9.utils.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitAgentImpl : MovieDataAgent {

    private val movieApi: MoviesApi

    init {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        movieApi = retrofit.create(MoviesApi::class.java)
    }

    override fun getTrailerVideos(movieId: Int, onSuccess: (TrailerVideoResponse) -> Unit, onFailure: (String) -> Unit) {
        val call = movieApi.getTrailer(movieId)
        call.enqueue(object : Callback<TrailerVideoResponse> {
            override fun onFailure(call: Call<TrailerVideoResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(call: Call<TrailerVideoResponse>, response: Response<TrailerVideoResponse>) {
                val movieResponse = response.body()
                if (movieResponse != null) {
                    onSuccess(movieResponse)
                } else {
                    onFailure(EM_NULL_RESPONSE)
                }
            }
        })
    }

    override fun getNowPlayingMovies(page: Int, onSuccess: (List<MovieVO>) -> Unit, onFailure: (String) -> Unit) {
        val call = movieApi.getNowPlayingMovies(page)
        call.enqueue(object : Callback<GetNowPlayingMovieResponse> {
            override fun onFailure(call: Call<GetNowPlayingMovieResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(call: Call<GetNowPlayingMovieResponse>, response: Response<GetNowPlayingMovieResponse>) {
                val movieResponse = response.body()
                if (movieResponse != null) {
                    onSuccess(movieResponse.results)
                } else {
                    onFailure(EM_NULL_RESPONSE)
                }
            }

        })
    }

    override fun getPopularMovies(page: Int, onSuccess: (List<MovieVO>) -> Unit, onFailure: (String) -> Unit) {
        val call = movieApi.getPopularMovies(page)
        call.enqueue(object : Callback<GetPopularMovieResponse> {
            override fun onFailure(call: Call<GetPopularMovieResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(call: Call<GetPopularMovieResponse>, responseGet: Response<GetPopularMovieResponse>) {
                val movieResponse = responseGet.body()
                if (movieResponse != null) {
                    onSuccess(movieResponse.results)
                } else {
                    onFailure(EM_NULL_RESPONSE)
                }
            }

        })
    }

    override fun getTopRatedMovies(page: Int, onSuccess: (List<MovieVO>) -> Unit, onFailure: (String) -> Unit) {
        val call = movieApi.getTopRatedMovies(page)
        call.enqueue(object : Callback<GetTopRatedMovieResponse> {
            override fun onFailure(call: Call<GetTopRatedMovieResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<GetTopRatedMovieResponse>,
                responseGet: Response<GetTopRatedMovieResponse>
            ) {
                val movieResponse = responseGet.body()
                if (movieResponse != null) {
                    onSuccess(movieResponse.results)
                } else {
                    onFailure(EM_NULL_RESPONSE)
                }
            }
        })
    }

    override fun getUpComingMovies(page: Int, onSuccess: (List<MovieVO>) -> Unit, onFailure: (String) -> Unit) {
        val call = movieApi.getUpComingMovies(page)
        call.enqueue(object : Callback<GetUpcomingMovieResponse> {
            override fun onFailure(call: Call<GetUpcomingMovieResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(call: Call<GetUpcomingMovieResponse>, response: Response<GetUpcomingMovieResponse>) {
                val movieResponse = response.body()
                if (movieResponse != null) {
                    onSuccess(movieResponse.results)
                } else {
                    onFailure(EM_NULL_RESPONSE)
                }
            }
        })
    }

    override fun getMovieDetail(
        id: Int,
        onSuccess: (MovieDetailVO) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val call = movieApi.getMovieDetail(id)
        call.enqueue(object : Callback<MovieDetailVO> {
            override fun onFailure(call: Call<MovieDetailVO>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(call: Call<MovieDetailVO>, response: Response<MovieDetailVO>) {
                val movieDetail = response.body()

                if (movieDetail != null) {
                    onSuccess(movieDetail)
                } else {
                    onFailure(EM_NULL_RESPONSE)
                }
            }

        })
    }

    override fun getSimilarMovies(
        id: Int,
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val call = movieApi.getSimilarMovies(id)
        call.enqueue(object : Callback<GetSimilarMovieResponse> {
            override fun onFailure(call: Call<GetSimilarMovieResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<GetSimilarMovieResponse>,
                response: Response<GetSimilarMovieResponse>
            ) {
                val similarMoviesResponse = response.body()
                if (similarMoviesResponse != null) {
                    if( similarMoviesResponse.results != null) {
                        onSuccess(similarMoviesResponse.results)
                    } else {
                        onFailure(EM_NULL_RESPONSE)
                    }
                } else {
                    onFailure(EM_NULL_RESPONSE)
                }
            }
        })
    }
}