package com.salim.android.tmdbclient.data.repository.artist.datasource

import com.salim.android.tmdbclient.data.model.artist.ArtistList
import com.salim.android.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface ArtistRemoteDatasource {
    suspend fun getArtists(): Response<ArtistList>
}