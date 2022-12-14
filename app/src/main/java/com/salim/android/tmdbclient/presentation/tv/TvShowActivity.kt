package com.salim.android.tmdbclient.presentation.tv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.salim.android.tmdbclient.R
import com.salim.android.tmdbclient.databinding.ActivityTvShowBinding

class TvShowActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTvShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_tv_show)
    }
}