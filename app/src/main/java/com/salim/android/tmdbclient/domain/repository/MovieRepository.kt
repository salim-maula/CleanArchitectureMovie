package com.salim.android.tmdbclient.domain.repository

import com.salim.android.tmdbclient.data.model.artist.Artist
import com.salim.android.tmdbclient.data.model.movie.Movie
import com.salim.android.tmdbclient.data.model.tv.TvShow

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?




}