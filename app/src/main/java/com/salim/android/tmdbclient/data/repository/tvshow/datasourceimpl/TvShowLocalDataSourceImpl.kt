package com.salim.android.tmdbclient.data.repository.tvshow.datasourceimpl

import com.salim.android.tmdbclient.data.db.ArtistDao
import com.salim.android.tmdbclient.data.db.TvShowDao
import com.salim.android.tmdbclient.data.model.artist.Artist
import com.salim.android.tmdbclient.data.model.tv.TvShow
import com.salim.android.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.salim.android.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowDao: TvShowDao): TvShowLocalDataSource{
    override suspend fun getTvShowsFromDB(): List<TvShow> {
        return tvShowDao.getTvShows()
    }

    override suspend fun saveTvShowsToDB(tvShow : List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShows(tvShow)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShows()
        }
    }
}