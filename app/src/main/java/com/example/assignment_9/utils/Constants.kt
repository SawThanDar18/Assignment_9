package com.example.assignment_9.utils

import com.example.assignment_9.BuildConfig

const val DB_NAME = "movieDB"
const val BASE_URL = "https://api.themoviedb.org/3/"
const val PARAM_PAGE = "page"
const val PARAM_QUERY = "query"
const val PARAM_API_KEY = "api_key"
const val API_KEY = BuildConfig.TMDB_API_KEY
const val LANGUAGE = "en-US"

const val EM_NULL_RESPONSE = "Check the Internet Connection!"

const val GET_MOVIES = "movie/"
const val GET_POPULAR = "movie/popular?api_key=$API_KEY&language=$LANGUAGE"
const val GET_TOP_RATED = "movie/top_rated?api_key=$API_KEY&language=$LANGUAGE"
const val GET_UPCOMING = "movie/upcoming?api_key=$API_KEY&language=$LANGUAGE"
const val GET_NOW_PLAYING = "movie/now_playing?api_key=$API_KEY&language=$LANGUAGE"
const val GET_VIDEOS = "movie/{id}/videos?api_key=$API_KEY&language=$LANGUAGE"
const val GET_SIMILAR_MOVIES = "movie/{id}/similar?api_key=$API_KEY&language=$LANGUAGE"
const val GET_SEARCH_MOVIES = "search/movie?api_key=$API_KEY&language=$LANGUAGE"
const val GET_MOVIE_DETAIL = "movie/{id}?api_key=$API_KEY&language=$LANGUAGE"
const val IMAGE_BASE_URL_W300 = "https://image.tmdb.org/t/p/w300"
