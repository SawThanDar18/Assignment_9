package com.example.assignment_9.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment_9.R
import com.example.assignment_9.viewHolders.UpComingViewHolder

class UpComingItemAdapter: RecyclerView.Adapter<UpComingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpComingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.upcoming_item_view, parent, false)
        return UpComingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: UpComingViewHolder, position: Int) {

    }
}