package com.salim.android.tmdbclient.domain.repository

import com.salim.android.tmdbclient.data.model.artist.Artist

interface ArtistRepository {

    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtists(): List<Artist>?
}