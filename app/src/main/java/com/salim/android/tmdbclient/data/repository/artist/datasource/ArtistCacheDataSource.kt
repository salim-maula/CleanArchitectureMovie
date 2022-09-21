package com.salim.android.tmdbclient.data.repository.artist.datasource

import com.salim.android.tmdbclient.data.model.artist.Artist
import com.salim.android.tmdbclient.data.model.movie.Movie

interface ArtistCacheDataSource {
    suspend fun getArtistsFromCache(): List<Artist>
    suspend fun saveArtistsToCache(artists : List<Artist>)
}