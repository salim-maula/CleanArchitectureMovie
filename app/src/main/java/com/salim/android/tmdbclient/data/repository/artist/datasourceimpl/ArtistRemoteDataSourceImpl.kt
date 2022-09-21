package com.salim.android.tmdbclient.data.repository.artist.datasourceimpl

import com.salim.android.tmdbclient.data.api.TMDBService
import com.salim.android.tmdbclient.data.model.artist.ArtistList
import com.salim.android.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey:String):
    ArtistRemoteDatasource {

//    override suspend fun getMovies(): Response<MovieList> {
//        return tmdbService.getPopularMovies(apiKey)
//    }
    override suspend fun getArtists(): Response<ArtistList> = tmdbService.getPopularArtists(apiKey)
}