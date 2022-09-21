package com.salim.android.tmdbclient.data.repository.tvshow.datasource

import com.salim.android.tmdbclient.data.model.artist.Artist
import com.salim.android.tmdbclient.data.model.movie.Movie
import com.salim.android.tmdbclient.data.model.tv.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowsFromCache(): List<TvShow>
    suspend fun saveTvShowsToCache(tvShow : List<TvShow>)
}