package com.alfian.moviecatalogue.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.alfian.moviecatalogue.R
import com.alfian.moviecatalogue.adapter.SectionsPagerAdapter
import com.alfian.moviecatalogue.databinding.ActivityListFilmBinding

class ListFilmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_MovieCatalogue)
        super.onCreate(savedInstanceState)

        val activityListFilmBinding = ActivityListFilmBinding.inflate(layoutInflater)

        setContentView(activityListFilmBinding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        activityListFilmBinding.viewPager.adapter = sectionsPagerAdapter
        activityListFilmBinding.tabs.setupWithViewPager(activityListFilmBinding.viewPager)

        supportActionBar?.elevation = 0f

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.favorite_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.favorite_film -> {
                val i = Intent(this, FavoriteFilmActivity::class.java)
                startActivity(i)
                true
            }
            else -> true
        }
    }

}