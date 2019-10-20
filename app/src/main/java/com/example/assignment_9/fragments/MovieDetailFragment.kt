package com.example.assignment_9.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.example.assignment_9.R
import com.example.assignment_9.activities.MainActivity
import com.example.assignment_9.adapters.MovieListAdapter
import com.example.assignment_9.data.vos.MovieDetailVO
import com.example.assignment_9.data.vos.MovieVO
import com.example.assignment_9.mvp.presenters.MainPresenter
import com.example.assignment_9.mvp.presenters.MovieDetailPresenter
import com.example.assignment_9.mvp.views.MovieDetailView
import com.example.assignment_9.utils.IMAGE_BASE_URL_W300
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import kotlinx.android.synthetic.main.fragment_movie_detail.view.*
import kotlinx.android.synthetic.main.layout_youtube_player.view.*

class MovieDetailFragment: BaseFragment(), MovieDetailView {

    private var videoId: String? = ""

    override fun showTrailers() {
        showTrailers(videoId!!)
    }

    private lateinit var mainPresenter: MainPresenter
    private lateinit var movieDetailPresenter: MovieDetailPresenter

    private lateinit var movieAdapter: MovieListAdapter

    companion object{

        const val EXTRA_MOVIE_ID = "movieId"

        fun newFragment(movieId: Int): Fragment {
            val bundle = Bundle()
            bundle.putInt(EXTRA_MOVIE_ID, movieId)

            val fragment = MovieDetailFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieDetailPresenter = ViewModelProviders.of(this).get(MovieDetailPresenter::class.java)
        movieDetailPresenter.initPresenter(this)

        movieAdapter = MovieListAdapter(mainPresenter)

        val id = this.arguments!!.getInt(EXTRA_MOVIE_ID, 0)

        movieAdapter = MovieListAdapter(mainPresenter)
        with(view.more_movies_rv){
            setHasFixedSize(true)
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            adapter = movieAdapter
        }

        view.clear_iv.setOnClickListener {

        }

        view.constraintLayout.setOnClickListener {
            movieDetailPresenter.playTrailer(videoId!!)
        }

        movieDetailPresenter.onUiReady(this, id)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val activity = context as MainActivity
        mainPresenter = activity.getPresenter()
    }

    override fun displayMovieDetail(data: MovieDetailVO) {
        bindData(data)
    }

    override fun displaySimilarMovies(movies: List<MovieVO>) {
        movieAdapter.setNewData(movies.toMutableList())
    }

    override fun errorMessage(errorMessage: String) {
        errorMessage(errorMessage)
    }

    fun bindData(data: MovieDetailVO){
        view!!.detail_movie_iv.load(IMAGE_BASE_URL_W300 + data.posterPath)
        view!!.movie_year_tv.text = data.releaseDate
        view!!.movie_duration_tv.text = data.runTime.toString() + " min"
        view!!.movie_desc_tv.text = data.overview
    }

    fun showTrailers(videoId: String) {
        val dialog = LayoutInflater.from(context).inflate(R.layout.layout_youtube_player, null)
        lifecycle.addObserver(dialog.youtube_player)
        dialog.youtube_player.addYouTubePlayerListener(object :
            AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(videoId, 0f)
            }
        })

        AlertDialog.Builder(context!!).setView(dialog).show()
    }
}