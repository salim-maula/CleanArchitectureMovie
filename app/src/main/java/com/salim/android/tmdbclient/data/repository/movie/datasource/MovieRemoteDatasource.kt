package com.salim.android.tmdbclient.data.repository.movie.datasource

import com.salim.android.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {
    suspend fun getMovies(): Response<MovieList>
}