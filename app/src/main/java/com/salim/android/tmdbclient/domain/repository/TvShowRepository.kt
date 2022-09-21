package com.salim.android.tmdbclient.domain.repository

import com.salim.android.tmdbclient.data.model.tv.TvShow

interface TvShowRepository {
    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateTvShows(): List<TvShow>?
}