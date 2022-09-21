package com.salim.android.tmdbclient.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.salim.android.tmdbclient.R
import com.salim.android.tmdbclient.databinding.ActivityHomeBinding
import com.salim.android.tmdbclient.presentation.artist.ArtistActivity
import com.salim.android.tmdbclient.presentation.movie.MovieActivity
import com.salim.android.tmdbclient.presentation.tv.TvShowActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_home)
        binding.movieButton.setOnClickListener {
            startActivity(Intent(this, MovieActivity::class.java))
        }
        binding.tvButton.setOnClickListener {
            startActivity(Intent(this, TvShowActivity::class.java))
        }
        binding.artistsButton.setOnClickListener {
            startActivity(Intent(this, ArtistActivity::class.java))
        }


    }
}