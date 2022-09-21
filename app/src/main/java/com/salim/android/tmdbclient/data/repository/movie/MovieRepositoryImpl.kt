package com.salim.android.tmdbclient.data.repository.movie

import android.util.Log
import com.salim.android.tmdbclient.data.model.movie.Movie
import com.salim.android.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.salim.android.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.salim.android.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.salim.android.tmdbclient.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDatasource: MovieRemoteDatasource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {

    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
       val newListOfMovies = getMoviesFromApi()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMovieToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    //add new function
    suspend fun getMoviesFromApi(): List<Movie>{

        lateinit var movieList: List<Movie>

        try {
            val response = movieRemoteDatasource.getMovies()
            val body = response.body()
            if (body!=null){
                movieList = body.movies
            }
        }catch (exception:Exception){
            Log.i("TAG", "getMoviesFromApi: ${exception.message.toString()}")
        }
        return movieList
    }

    suspend fun getMovieFromDB(): List<Movie>{

        lateinit var movieList: List<Movie>

        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
        }catch (exception:Exception){
            Log.i("TAG", "getMoviesFromApi: ${exception.message.toString()}")
        }

        if (movieList.size>0){
            return movieList
        }else{
            movieList = getMoviesFromApi()
            movieLocalDataSource.saveMovieToDB(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache(): List<Movie>{

        lateinit var movieList: List<Movie>

        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        }catch (exception:Exception){
            Log.i("TAG", "getMoviesFromApi: ${exception.message.toString()}")
        }

        if (movieList.size>0){
            return movieList
        }else{
            movieList = getMovieFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }

}