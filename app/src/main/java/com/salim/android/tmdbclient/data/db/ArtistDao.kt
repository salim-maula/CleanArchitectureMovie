package com.salim.android.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.salim.android.tmdbclient.data.model.artist.Artist
import com.salim.android.tmdbclient.data.model.movie.Movie

@Dao
interface ArtistDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtists(artists : List<Artist>)

    @Query("DELETE  FROM popular_artist")
    suspend fun deleteAllArtists()

    @Query("SELECT * FROM popular_artist")
    suspend fun getArtists() : List<Artist>
}