package com.salim.android.tmdbclient.domain.usecase

import com.salim.android.tmdbclient.data.model.artist.Artist
import com.salim.android.tmdbclient.domain.repository.ArtistRepository

class GetArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun excute(): List<Artist>? = artistRepository.getArtists()
}