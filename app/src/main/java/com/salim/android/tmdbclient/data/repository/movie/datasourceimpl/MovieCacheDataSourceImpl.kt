package com.salim.android.tmdbclient.data.repository.movie.datasourceimpl

import com.salim.android.tmdbclient.data.model.movie.Movie
import com.salim.android.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl : MovieCacheDataSource {

    private var movieList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}