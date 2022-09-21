package com.salim.android.tmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.salim.android.tmdbclient.data.model.artist.Artist
import com.salim.android.tmdbclient.data.model.movie.Movie
import com.salim.android.tmdbclient.data.model.tv.TvShow

@Database(entities = [Movie::class, TvShow::class, Artist::class], version = 1, exportSchema = false)
abstract class TMDBDatabase : RoomDatabase() {
    abstract fun  movieDao() : MovieDao
    abstract fun tvDao() : TvShowDao
    abstract fun artist(): ArtistDao
}