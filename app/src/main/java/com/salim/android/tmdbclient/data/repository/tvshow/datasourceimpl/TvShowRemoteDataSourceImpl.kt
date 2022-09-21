package com.salim.android.tmdbclient.data.repository.tvshow.datasourceimpl

import com.salim.android.tmdbclient.data.api.TMDBService
import com.salim.android.tmdbclient.data.model.artist.ArtistList
import com.salim.android.tmdbclient.data.model.tv.TvShow
import com.salim.android.tmdbclient.data.model.tv.TvShowList
import com.salim.android.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import com.salim.android.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey:String):
    TvShowRemoteDatasource {

//    override suspend fun getMovies(): Response<MovieList> {
//        return tmdbService.getPopularMovies(apiKey)
//    }
    override suspend fun getTvShows(): Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)
}