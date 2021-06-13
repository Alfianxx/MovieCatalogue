package com.alfian.moviecatalogue.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.alfian.moviecatalogue.adapter.FavoriteSectionsPagerAdapter

import com.alfian.moviecatalogue.databinding.ActivityFavoriteFilmBinding


class FavoriteFilmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityFavoriteFilmBinding = ActivityFavoriteFilmBinding.inflate(layoutInflater)
        setContentView(activityFavoriteFilmBinding.root)

        supportActionBar?.title = "Favorite Film"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val favoriteSectionsPagerAdapter = FavoriteSectionsPagerAdapter(this, supportFragmentManager)
        activityFavoriteFilmBinding.viewPager.adapter = favoriteSectionsPagerAdapter
        activityFavoriteFilmBinding.tabs.setupWithViewPager(activityFavoriteFilmBinding.viewPager)

        supportActionBar?.elevation = 0f

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}