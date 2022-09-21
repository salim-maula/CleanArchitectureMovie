package com.salim.android.tmdbclient.presentation.artist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.salim.android.tmdbclient.domain.usecase.GetArtistsUseCase
import com.salim.android.tmdbclient.domain.usecase.GetMoviesUseCase
import com.salim.android.tmdbclient.domain.usecase.UpdateArtistsUseCase
import com.salim.android.tmdbclient.domain.usecase.UpdateMovieUsecase

class ArtistViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
): ViewModel() {

    fun getArtists()  = liveData {
        val artistList = getArtistsUseCase.excute()
        emit(artistList)
    }

    fun updateArtists() = liveData {
        val artistList = updateArtistsUseCase.excute()
        emit(artistList)
    }
}