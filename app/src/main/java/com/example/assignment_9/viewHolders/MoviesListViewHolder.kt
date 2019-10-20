package com.example.assignment_9.viewHolders

import android.view.View
import coil.api.load
import com.example.assignment_9.data.vos.MovieVO
import com.example.assignment_9.delegates.ItemClicked
import com.example.assignment_9.utils.IMAGE_BASE_URL_W300
import kotlinx.android.synthetic.main.movie_list_item_view.view.*

class MoviesListViewHolder(itemView: View, private val delegate: ItemClicked): BaseViewHolder<MovieVO>(itemView) {

    init {
        itemView.movie_iv.setOnClickListener {
            data?.id?.let {id ->
                delegate.onClicked(id)
            }
        }
    }

    override fun bindData(movie: MovieVO) {
        itemView.movie_iv.load(IMAGE_BASE_URL_W300 + movie.posterImage)
    }

}