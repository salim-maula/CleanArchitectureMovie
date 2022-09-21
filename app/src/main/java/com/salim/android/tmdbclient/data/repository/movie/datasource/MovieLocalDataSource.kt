package com.salim.android.tmdbclient.data.repository.movie.datasource

import com.salim.android.tmdbclient.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMovieToDB(movies: List<Movie>)
    suspend fun clearAll()
}