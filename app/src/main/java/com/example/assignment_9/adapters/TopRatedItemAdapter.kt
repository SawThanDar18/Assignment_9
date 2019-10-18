package com.example.assignment_9.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment_9.R
import com.example.assignment_9.viewHolders.TopRatedViewHolder

class TopRatedItemAdapter: RecyclerView.Adapter<TopRatedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.top_rated_item_view, parent, false)
        return TopRatedViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: TopRatedViewHolder, position: Int) {

    }
}