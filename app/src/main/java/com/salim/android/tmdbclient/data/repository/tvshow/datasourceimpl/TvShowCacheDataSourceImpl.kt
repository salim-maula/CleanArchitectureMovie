package com.salim.android.tmdbclient.data.repository.tvshow.datasourceimpl

import com.salim.android.tmdbclient.data.model.artist.Artist
import com.salim.android.tmdbclient.data.model.tv.TvShow
import com.salim.android.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.salim.android.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl : TvShowCacheDataSource {

    private var tvShowList = ArrayList<TvShow>()

    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowsToCache(tvShow: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShow)
    }
}