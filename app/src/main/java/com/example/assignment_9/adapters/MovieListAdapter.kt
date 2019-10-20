package com.example.assignment_9.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.assignment_9.R
import com.example.assignment_9.data.vos.MovieVO
import com.example.assignment_9.delegates.ItemClicked
import com.example.assignment_9.viewHolders.MoviesListViewHolder

class MovieListAdapter(private val delegate: ItemClicked): BaseAdapter<MoviesListViewHolder, MovieVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.movie_list_item_view, parent, false)
        return MoviesListViewHolder(itemView, delegate)
    }
}