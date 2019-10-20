package com.example.assignment_9.activities

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.assignment_9.R
import com.example.assignment_9.fragments.*
import com.example.assignment_9.mvp.presenters.MainPresenter
import com.example.assignment_9.mvp.views.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(),MainView {

    override fun navigateToMovieDetail(id: Int) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, MovieDetailFragment.newFragment(id))
            .commit()
    }

    fun getPresenter(): MainPresenter {
        return mainPresenter
    }

    private lateinit var mainPresenter: MainPresenter

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> goToFragment(MovieListFragment())

                R.id.navigation_search -> goToFragment(SearchFragment())

                R.id.navigation_player -> goToFragment(ComingSoonFragment())

                R.id.navigation_download -> goToFragment(DownloadFragment())

                R.id.navigation_more -> goToFragment(MoreFragment())
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainPresenter = ViewModelProviders.of(this).get(MainPresenter::class.java)
        mainPresenter.initPresenter(this)

        nav_view.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        goToFragment(MovieListFragment())

    }

    private fun goToFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .commit()
    }
}
