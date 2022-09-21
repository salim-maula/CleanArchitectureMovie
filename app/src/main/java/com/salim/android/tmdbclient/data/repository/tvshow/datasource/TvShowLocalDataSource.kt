package com.salim.android.tmdbclient.data.repository.tvshow.datasource

import com.salim.android.tmdbclient.data.model.artist.Artist
import com.salim.android.tmdbclient.data.model.tv.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowsFromDB(): List<TvShow>
    suspend fun saveTvShowsToDB(tvShow: List<TvShow>)
    suspend fun clearAll()
}