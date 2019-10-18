package com.example.assignment_9.activities

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.assignment_9.R
import com.example.assignment_9.fragments.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

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

        nav_view.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        goToFragment(MovieListFragment())
    }

    private fun goToFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .commit()
    }
}
