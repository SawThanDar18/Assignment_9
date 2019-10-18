package com.example.assignment_9.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment_9.R
import com.example.assignment_9.adapters.NowPlayingItemAdapter
import com.example.assignment_9.adapters.PopularItemAdapter
import com.example.assignment_9.adapters.TopRatedItemAdapter
import com.example.assignment_9.adapters.UpComingItemAdapter
import kotlinx.android.synthetic.main.fragment_movie_list.*

class MovieListFragment : BaseFragment() {

    private lateinit var nowPlayingItemAdapter: NowPlayingItemAdapter
    private lateinit var popularItemAdapter: PopularItemAdapter
    private lateinit var topRatedItemAdapter: TopRatedItemAdapter
    private lateinit var upComingItemAdapter: UpComingItemAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val layout = inflater.inflate(R.layout.fragment_movie_list, container, false)
        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nowPlayingItemAdapter = NowPlayingItemAdapter()
        with(now_playing_rv){
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            adapter = nowPlayingItemAdapter
        }

        popularItemAdapter = PopularItemAdapter()
        with(popular_rv){
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            adapter = popularItemAdapter
        }

        topRatedItemAdapter = TopRatedItemAdapter()
        with(top_rated_rv){
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            adapter = topRatedItemAdapter
        }

        upComingItemAdapter = UpComingItemAdapter()
        with(upcoming_rv){
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            adapter = upComingItemAdapter
        }
    }
}