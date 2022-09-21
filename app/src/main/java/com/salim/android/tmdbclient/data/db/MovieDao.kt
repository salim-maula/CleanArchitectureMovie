package com.salim.android.tmdbclient.data.db

import androidx.room.*
import com.salim.android.tmdbclient.data.model.movie.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies : List<Movie>)

    @Query("DELETE  FROM popular_movies")
    suspend fun deleteAllMovies()

    @Query("SELECT * FROM popular_movies")
    suspend fun getMovies() : List<Movie>

}