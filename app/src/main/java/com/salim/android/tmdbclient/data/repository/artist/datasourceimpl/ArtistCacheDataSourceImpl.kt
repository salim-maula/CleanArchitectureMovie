package com.salim.android.tmdbclient.data.repository.artist.datasourceimpl

import com.salim.android.tmdbclient.data.model.artist.Artist
import com.salim.android.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl : ArtistCacheDataSource {

    private var artistList = ArrayList<Artist>()

    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistsToCache(movies: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(movies)
    }
}