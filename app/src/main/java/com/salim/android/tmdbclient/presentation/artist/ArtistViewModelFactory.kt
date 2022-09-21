package com.salim.android.tmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.salim.android.tmdbclient.domain.usecase.GetArtistsUseCase
import com.salim.android.tmdbclient.domain.usecase.GetMoviesUseCase
import com.salim.android.tmdbclient.domain.usecase.UpdateArtistsUseCase
import com.salim.android.tmdbclient.domain.usecase.UpdateMovieUsecase

class ArtistViewModelFactory(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistViewModel(getArtistsUseCase, updateArtistsUseCase) as T
    }
}