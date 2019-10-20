package com.example.assignment_9.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment_9.R
import com.example.assignment_9.activities.MainActivity
import com.example.assignment_9.adapters.MovieListAdapter
import com.example.assignment_9.data.vos.MovieVO
import com.example.assignment_9.mvp.presenters.MainPresenter
import com.example.assignment_9.mvp.presenters.MovieListPresenter
import com.example.assignment_9.mvp.views.MovieListView
import kotlinx.android.synthetic.main.fragment_movie_list.*

class MovieListFragment : BaseFragment(), MovieListView {

    override fun showTopRatedMovie(movies: List<MovieVO>) {
        topRatedItemAdapter.setNewData(movies.toMutableList())
    }

    override fun showPopularMovie(movies: List<MovieVO>) {
        popularItemAdapter.setNewData(movies.toMutableList())
    }

    override fun showUpcomingMovie(movies: List<MovieVO>) {
        upComingItemAdapter.setNewData(movies.toMutableList())
    }

    override fun showNowPlayingMovie(movies: List<MovieVO>) {
        nowPlayingItemAdapter.setNewData(movies.toMutableList())
    }

    override fun errorMessage(errorMessage: String) {
        errorMessage(errorMessage)
    }

    private lateinit var mainPresenter: MainPresenter
    private lateinit var movieListPresenter: MovieListPresenter

    private lateinit var nowPlayingItemAdapter: MovieListAdapter
    private lateinit var popularItemAdapter: MovieListAdapter
    private lateinit var topRatedItemAdapter: MovieListAdapter
    private lateinit var upComingItemAdapter: MovieListAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val parentActivity = context as MainActivity
        mainPresenter = parentActivity.getPresenter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val layout = inflater.inflate(R.layout.fragment_movie_list, container, false)
        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieListPresenter = ViewModelProviders.of(this).get(MovieListPresenter::class.java)
        movieListPresenter.initPresenter(this)

        nowPlayingItemAdapter = MovieListAdapter(mainPresenter)
        with(now_playing_rv) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            adapter = nowPlayingItemAdapter
        }

        popularItemAdapter = MovieListAdapter(mainPresenter)
        with(popular_rv){
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            adapter = popularItemAdapter
        }

        topRatedItemAdapter = MovieListAdapter(mainPresenter)
        with(top_rated_rv){
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            adapter = topRatedItemAdapter
        }

        upComingItemAdapter = MovieListAdapter(mainPresenter)
        with(upcoming_rv){
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            adapter = upComingItemAdapter
        }

        movieListPresenter.onUiReady(this)
    }

}