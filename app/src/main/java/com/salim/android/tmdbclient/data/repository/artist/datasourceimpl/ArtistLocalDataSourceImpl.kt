package com.salim.android.tmdbclient.data.repository.artist.datasourceimpl

import com.salim.android.tmdbclient.data.db.ArtistDao
import com.salim.android.tmdbclient.data.model.artist.Artist
import com.salim.android.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistsDao: ArtistDao): ArtistLocalDataSource {
    override suspend fun getArtistsFromDB(): List<Artist> {
        return artistsDao.getArtists()
    }

    override suspend fun saveArtistsToDB(artists : List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistsDao.saveArtists(artists)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistsDao.deleteAllArtists()
        }
    }
}