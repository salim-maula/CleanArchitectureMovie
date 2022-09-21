package com.salim.android.tmdbclient.data.repository.movie.datasourceimpl

import com.salim.android.tmdbclient.data.api.TMDBService
import com.salim.android.tmdbclient.data.model.movie.MovieList
import com.salim.android.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val tmdbService: TMDBService,private val apiKey:String):
    MovieRemoteDatasource {

//    override suspend fun getMovies(): Response<MovieList> {
//        return tmdbService.getPopularMovies(apiKey)
//    }
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)
}