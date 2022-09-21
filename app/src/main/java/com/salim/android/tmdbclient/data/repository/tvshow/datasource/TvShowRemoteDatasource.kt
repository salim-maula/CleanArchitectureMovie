package com.salim.android.tmdbclient.data.repository.tvshow.datasource

import com.salim.android.tmdbclient.data.model.artist.ArtistList
import com.salim.android.tmdbclient.data.model.movie.MovieList
import com.salim.android.tmdbclient.data.model.tv.TvShow
import com.salim.android.tmdbclient.data.model.tv.TvShowList
import retrofit2.Response

interface TvShowRemoteDatasource {
    suspend fun getTvShows(): Response<TvShowList>
}