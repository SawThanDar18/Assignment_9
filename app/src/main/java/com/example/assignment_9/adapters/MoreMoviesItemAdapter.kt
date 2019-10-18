package com.example.assignment_9.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment_9.R
import com.example.assignment_9.viewHolders.MoreMoviesViewHolder

class MoreMoviesItemAdapter: RecyclerView.Adapter<MoreMoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoreMoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.now_playing_item_view, parent, false)
        return MoreMoviesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: MoreMoviesViewHolder, position: Int) {

    }
}