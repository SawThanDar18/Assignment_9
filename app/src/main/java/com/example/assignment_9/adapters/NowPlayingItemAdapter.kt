package com.example.assignment_9.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment_9.R
import com.example.assignment_9.viewHolders.NowPlayingViewHolder

class NowPlayingItemAdapter: RecyclerView.Adapter<NowPlayingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NowPlayingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.now_playing_item_view, parent, false)
        return NowPlayingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: NowPlayingViewHolder, position: Int) {

    }
}