package com.salim.android.tmdbclient.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.salim.android.tmdbclient.domain.usecase.GetMoviesUseCase
import com.salim.android.tmdbclient.domain.usecase.GetTvShowsUseCase
import com.salim.android.tmdbclient.domain.usecase.UpdateMovieUsecase
import com.salim.android.tmdbclient.domain.usecase.UpdateTvShowUseCase

class TvShowViewModelFactory(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowsUseCase, updateTvShowUseCase) as T
    }
}